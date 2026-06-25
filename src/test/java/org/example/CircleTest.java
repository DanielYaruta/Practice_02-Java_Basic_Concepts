package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    private Circle circle;

    @BeforeEach
    void setUp() {
        circle = new Circle(5.0);
    }

    // --- Конструктор ---

    @Test
    void constructor_validRadius_initializesField() {
        assertEquals(5.0, circle.getRadius());
    }

    @Test
    void constructor_zeroRadius_throwsException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Circle(0)
        );
        assertEquals("Радиус должен быть больше нуля", ex.getMessage());
    }

    @Test
    void constructor_negativeRadius_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(-1.0));
    }

    // --- setRadius ---

    @Test
    void setRadius_validValue_updatesRadius() {
        circle.setRadius(10.0);
        assertEquals(10.0, circle.getRadius());
    }

    @Test
    void setRadius_zeroValue_throwsException() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> circle.setRadius(0)
        );
        assertEquals("Радиус должен быть больше нуля", ex.getMessage());
    }

    @Test
    void setRadius_negativeValue_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> circle.setRadius(-5.0));
    }

    @Test
    void setRadius_invalidValue_doesNotChangeRadius() {
        assertThrows(IllegalArgumentException.class, () -> circle.setRadius(-1.0));
        assertEquals(5.0, circle.getRadius());
    }

    // --- getArea ---

    @Test
    void getArea_radiusOne_returnsPI() {
        Circle c = new Circle(1.0);
        assertEquals(Math.PI, c.getArea(), 1e-9);
    }

    @Test
    void getArea_radiusFive_returnsCorrectArea() {
        assertEquals(Math.PI * 25, circle.getArea(), 1e-9);
    }

    @Test
    void getArea_updatesAfterSetRadius() {
        circle.setRadius(3.0);
        assertEquals(Math.PI * 9, circle.getArea(), 1e-9);
    }

    // --- Граничные значения ---

    @Test
    void constructor_nanRadius_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(Double.NaN));
    }

    @Test
    void constructor_infiniteRadius_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(Double.POSITIVE_INFINITY));
    }

    @Test
    void constructor_exceedsMaxRadius_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> new Circle(Circle.MAX_RADIUS + 1));
    }

    @Test
    void constructor_maxRadiusExact_isValid() {
        Circle c = new Circle(Circle.MAX_RADIUS);
        assertEquals(Circle.MAX_RADIUS, c.getRadius());
    }

    // --- toString ---

    @Test
    void toString_containsRadiusAndArea() {
        String result = new Circle(5.0).toString();
        assertTrue(result.contains("КРУГ"));
        assertTrue(result.contains("5,00") || result.contains("5.00"));
        assertTrue(result.contains("78,54") || result.contains("78.54"));
    }

    @Test
    void toString_largeRadius_doesNotBreakLayout() {
        String result = new Circle(10_000.0).toString();
        for (String line : result.split(System.lineSeparator())) {
            assertTrue(line.length() <= 35, "Строка шире рамки: " + line);
        }
    }
}
