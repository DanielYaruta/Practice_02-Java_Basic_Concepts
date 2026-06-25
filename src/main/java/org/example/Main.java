package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHelper input = new InputHelper(scanner);

        do {
            double radius = input.readPositiveDouble("Введите радиус круга: ");
            Circle circle = new Circle(radius);
            System.out.println(circle);
        } while (input.readYesNo("Вычислить ещё один круг?"));

        System.out.println("Программа завершена.");
        scanner.close();
    }
}
