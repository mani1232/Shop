package utils;

import exceptions.CustomException;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

// Валидатор ввода значений
public class Validator {

    // Валидация ввода имени
    public static String validateName(Scanner scanner) {
        do {
            String str = scanner.nextLine().trim();
            try {
                if (str.isEmpty())
                    throw new CustomException(Constants.EMPTY_NAME_MSG);
                return str;
            } catch (CustomException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    // Валидация ввода количества
    public static int validateQuantityInput(Scanner scanner) {
        do {
            String quantity = scanner.nextLine().trim();
            try {
                int quantityNum = Integer.parseInt(quantity);
                if (quantityNum <= 0)
                    throw new CustomException(Constants.INCORRECT_QUANTITY_MSG);
                return quantityNum;
            } catch (CustomException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.printf(Constants.NAN_QUANTITY_MSG, quantity);
            }
        } while (true);
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
