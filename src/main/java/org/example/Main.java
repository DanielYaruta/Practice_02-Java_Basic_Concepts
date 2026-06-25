package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            InputHelper input = new InputHelper(scanner);

            do {
                double radius = input.readPositiveDouble("Введите радиус круга: ", Circle.MAX_RADIUS);
                System.out.println(new Circle(radius));
            } while (input.readYesNo("Вычислить ещё один круг?"));

            System.out.println("Программа завершена.");
        }
    }
}
