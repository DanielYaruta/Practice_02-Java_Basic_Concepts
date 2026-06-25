package org.example;

public class TestCircle {

    private static int passed = 0;
    private static int failed = 0;

    private static void assertTrue(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASSED] " + testName);
            passed++;
        } else {
            System.out.println("[FAILED] " + testName);
            failed++;
        }
    }

    // --- Тесты конструктора ---

    static void testConstructorValidRadius() {
        Circle circle = new Circle(7.0);
        assertTrue("Конструктор: корректная инициализация радиуса", circle.getRadius() == 7.0);
    }

    static void testConstructorZeroRadius() {
        try {
            new Circle(0);
            assertTrue("Конструктор: исключение при радиусе = 0", false);
        } catch (IllegalArgumentException e) {
            assertTrue("Конструктор: исключение при радиусе = 0", true);
        }
    }

    static void testConstructorNegativeRadius() {
        try {
            new Circle(-5.0);
            assertTrue("Конструктор: исключение при отрицательном радиусе", false);
        } catch (IllegalArgumentException e) {
            assertTrue("Конструктор: исключение при отрицательном радиусе", true);
        }
    }

    // --- Тесты setRadius ---

    static void testSetRadiusValidValue() {
        Circle circle = new Circle(3.0);
        circle.setRadius(8.0);
        assertTrue("setRadius: корректное обновление радиуса", circle.getRadius() == 8.0);
    }

    static void testSetRadiusZero() {
        Circle circle = new Circle(3.0);
        try {
            circle.setRadius(0);
            assertTrue("setRadius: исключение при радиусе = 0", false);
        } catch (IllegalArgumentException e) {
            assertTrue("setRadius: исключение при радиусе = 0", true);
        }
    }

    static void testSetRadiusNegativeValue() {
        Circle circle = new Circle(3.0);
        try {
            circle.setRadius(-1.0);
            assertTrue("setRadius: исключение при отрицательном радиусе", false);
        } catch (IllegalArgumentException e) {
            assertTrue("setRadius: исключение при отрицательном радиусе", true);
        }
    }

    // --- Тесты getArea ---

    static void testGetAreaWithRadius1() {
        Circle circle = new Circle(1.0);
        double expected = Math.PI;
        assertTrue("getArea: площадь при радиусе 1", circle.getArea() == expected);
    }

    static void testGetAreaWithRadius5() {
        Circle circle = new Circle(5.0);
        double expected = Math.PI * 25;
        assertTrue("getArea: площадь при радиусе 5", circle.getArea() == expected);
    }

    static void testGetAreaAfterSetRadius() {
        Circle circle = new Circle(3.0);
        circle.setRadius(4.0);
        double expected = Math.PI * 16;
        assertTrue("getArea: площадь пересчитывается после setRadius", circle.getArea() == expected);
    }

    public static void main(String[] args) {
        System.out.println("=== Тесты конструктора ===");
        testConstructorValidRadius();
        testConstructorZeroRadius();
        testConstructorNegativeRadius();

        System.out.println("\n=== Тесты setRadius ===");
        testSetRadiusValidValue();
        testSetRadiusZero();
        testSetRadiusNegativeValue();

        System.out.println("\n=== Тесты getArea ===");
        testGetAreaWithRadius1();
        testGetAreaWithRadius5();
        testGetAreaAfterSetRadius();

        System.out.println("\n--- Результат: " + passed + " passed, " + failed + " failed ---");
    }
}
