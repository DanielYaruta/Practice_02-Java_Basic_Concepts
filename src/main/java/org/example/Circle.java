package org.example;

public class Circle {
    public static final double MAX_RADIUS = 1_000_000;

    private double radius;

    public Circle(double radius) {
        validate(radius);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        validate(radius);
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format(
                "┌─────────────────────────┐%n" +
                "│         КРУГ            │%n" +
                "├─────────────────────────┤%n" +
                "│  Радиус:   %10.2f   │%n" +
                "│  Площадь:  %10.2f   │%n" +
                "└─────────────────────────┘",
                radius, getArea()
        );
    }

    private static void validate(double radius) {
        if (Double.isNaN(radius)) {
            throw new IllegalArgumentException("Радиус не может быть NaN");
        }
        if (Double.isInfinite(radius)) {
            throw new IllegalArgumentException("Радиус не может быть бесконечным");
        }
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус должен быть больше нуля");
        }
        if (radius > MAX_RADIUS) {
            throw new IllegalArgumentException("Радиус не может превышать " + (int) MAX_RADIUS);
        }
    }
}
