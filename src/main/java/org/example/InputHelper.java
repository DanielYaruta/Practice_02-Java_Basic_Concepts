package org.example;

import java.util.Scanner;

public class InputHelper {
    private final Scanner scanner;

    public InputHelper(Scanner scanner) {
        this.scanner = scanner;
    }

    public double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Ошибка: поле не может быть пустым. Попробуйте снова.");
                continue;
            }

            try {
                double value = Double.parseDouble(input);
                if (Double.isNaN(value) || Double.isInfinite(value)) {
                    System.out.println("Ошибка: недопустимое числовое значение. Попробуйте снова.");
                    continue;
                }
                if (value <= 0) {
                    System.out.println("Ошибка: значение должно быть больше нуля. Попробуйте снова.");
                    continue;
                }
                if (value > Circle.MAX_RADIUS) {
                    System.out.println("Ошибка: значение не может превышать " + (int) Circle.MAX_RADIUS + ". Попробуйте снова.");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите числовое значение. Попробуйте снова.");
            }
        }
    }

    public boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (да/нет): ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("да") || input.equals("д")) return true;
            if (input.equals("нет") || input.equals("н")) return false;
            System.out.println("Ошибка: введите 'да' или 'нет'.");
        }
    }
}
