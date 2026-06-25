package org.example;

public class TestCircle {

    private static int passed = 0;
    private static int failed = 0;

    private static void pass(String testName) {
        System.out.println("PASS: " + testName);
        passed++;
    }

    private static void fail(String testName, String reason) {
        System.out.println("FAIL: " + testName + " — " + reason);
        failed++;
    }

    // ─── Тесты конструктора ───────────────────────────────────────────────────

    static void testConstructor_validRadius_setsRadius() {
        Circle circle = new Circle(5.0);
        if (circle.getRadius() == 5.0) {
            pass("Конструктор: корректная инициализация радиуса");
        } else {
            fail("Конструктор: корректная инициализация радиуса",
                    "ожидалось 5.0, получено " + circle.getRadius());
        }
    }

    static void testConstructor_zeroRadius_throwsException() {
        try {
            new Circle(0);
            fail("Конструктор: исключение при radius = 0", "исключение не было выброшено");
        } catch (IllegalArgumentException e) {
            pass("Конструктор: исключение при radius = 0");
        }
    }

    static void testConstructor_negativeRadius_throwsException() {
        try {
            new Circle(-3.0);
            fail("Конструктор: исключение при radius < 0", "исключение не было выброшено");
        } catch (IllegalArgumentException e) {
            pass("Конструктор: исключение при radius < 0");
        }
    }

    // ─── Тесты setRadius ─────────────────────────────────────────────────────

    static void testSetRadius_validValue_updatesRadius() {
        Circle circle = new Circle(5.0);
        circle.setRadius(10.0);
        if (circle.getRadius() == 10.0) {
            pass("setRadius: корректное обновление радиуса");
        } else {
            fail("setRadius: корректное обновление радиуса",
                    "ожидалось 10.0, получено " + circle.getRadius());
        }
    }

    static void testSetRadius_zeroValue_throwsException() {
        Circle circle = new Circle(5.0);
        try {
            circle.setRadius(0);
            fail("setRadius: исключение при radius = 0", "исключение не было выброшено");
        } catch (IllegalArgumentException e) {
            pass("setRadius: исключение при radius = 0");
        }
    }

    static void testSetRadius_negativeValue_throwsException() {
        Circle circle = new Circle(5.0);
        try {
            circle.setRadius(-1.0);
            fail("setRadius: исключение при radius < 0", "исключение не было выброшено");
        } catch (IllegalArgumentException e) {
            pass("setRadius: исключение при radius < 0");
        }
    }

    static void testSetRadius_invalidValue_doesNotChangeRadius() {
        Circle circle = new Circle(5.0);
        try {
            circle.setRadius(-1.0);
        } catch (IllegalArgumentException e) {
            // ожидаемо
        }
        if (circle.getRadius() == 5.0) {
            pass("setRadius: радиус не изменился после недопустимого значения");
        } else {
            fail("setRadius: радиус не изменился после недопустимого значения",
                    "ожидалось 5.0, получено " + circle.getRadius());
        }
    }

    // ─── Тесты getArea ───────────────────────────────────────────────────────

    static void testGetArea_radiusOne_returnsPI() {
        Circle circle = new Circle(1.0);
        double expected = Math.PI;
        double actual = circle.getArea();
        if (Math.abs(actual - expected) < 1e-9) {
            pass("getArea: площадь при radius = 1 равна π");
        } else {
            fail("getArea: площадь при radius = 1 равна π",
                    "ожидалось " + expected + ", получено " + actual);
        }
    }

    static void testGetArea_radiusFive_returnsCorrectArea() {
        Circle circle = new Circle(5.0);
        double expected = Math.PI * 5.0 * 5.0;
        double actual = circle.getArea();
        if (Math.abs(actual - expected) < 1e-9) {
            pass("getArea: площадь при radius = 5");
        } else {
            fail("getArea: площадь при radius = 5",
                    "ожидалось " + expected + ", получено " + actual);
        }
    }

    static void testGetArea_updatesAfterSetRadius() {
        Circle circle = new Circle(3.0);
        circle.setRadius(4.0);
        double expected = Math.PI * 4.0 * 4.0;
        double actual = circle.getArea();
        if (Math.abs(actual - expected) < 1e-9) {
            pass("getArea: площадь пересчитывается после setRadius");
        } else {
            fail("getArea: площадь пересчитывается после setRadius",
                    "ожидалось " + expected + ", получено " + actual);
        }
    }

    // ─── Точка входа ─────────────────────────────────────────────────────────

    public static void main(String[] args) {
        System.out.println("=== Тесты конструктора ===");
        testConstructor_validRadius_setsRadius();
        testConstructor_zeroRadius_throwsException();
        testConstructor_negativeRadius_throwsException();

        System.out.println("\n=== Тесты setRadius ===");
        testSetRadius_validValue_updatesRadius();
        testSetRadius_zeroValue_throwsException();
        testSetRadius_negativeValue_throwsException();
        testSetRadius_invalidValue_doesNotChangeRadius();

        System.out.println("\n=== Тесты getArea ===");
        testGetArea_radiusOne_returnsPI();
        testGetArea_radiusFive_returnsCorrectArea();
        testGetArea_updatesAfterSetRadius();

        System.out.println("\n=== Итог: " + passed + " passed, " + failed + " failed из " + (passed + failed) + " ===");
    }
}
