package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

// Валидатор ввода значений
public class Validator {

    // Валидация ввода имени
    public static String validateName(Scanner scanner) {
        String str = scanner.nextLine().trim();
        while (str.isEmpty()) {
            System.out.print(Constants.EMPTY_NAME_MSG);
            str = scanner.nextLine().trim();
        }
        return str;
    }

    // Валидация ввода количества
    public static int validateQuantityInput(Scanner scanner) {

        int quantity;
        String str1 = null;

        while (!scanner.hasNextInt()) {
            String str = scanner.nextLine().trim();
            System.out.printf(Constants.NAN_QUANTITY_MSG, str);
        }
        quantity = scanner.nextInt();
        while (quantity <= 0) {
            System.out.println(Constants.INCORRECT_QUANTITY_MSG);
            while (!scanner.hasNextInt()) {
                try {
                    str1 = scanner.next().trim();
                } catch (InputMismatchException ime) {
                    System.out.printf(Constants.NAN_QUANTITY_MSG, str1);
                }
            }
            quantity = scanner.nextInt();
        }
        return quantity;
    }

    // Валидация ввода цены
    public static double validatePriceInput(Scanner scanner) {

        double price;
        String str1 = null;

        while (!scanner.hasNextDouble()) {
            String str = scanner.nextLine().trim();
            System.out.printf(Constants.NAN_PRICE_MSG, str);
        }
        price = scanner.nextDouble();
        while (price <= 0) {
            System.out.print(Constants.INCORRECT_PRICE_MSG);
            while (!scanner.hasNextDouble()) {
                try {
                    str1 = scanner.nextLine().trim();
                } catch (InputMismatchException ime) {
                    System.out.printf(Constants.NAN_PRICE_MSG, str1);
                }
            }
            price = scanner.nextDouble();
        }
        return price;
    }
}
