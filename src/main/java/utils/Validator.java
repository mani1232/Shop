package utils;

import exceptions.CustomException;

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
        do {
            String price = scanner.nextLine().trim();
            try {
                double priceNum = Double.parseDouble(price);
                if (priceNum <= 0)
                    throw new CustomException(Constants.INCORRECT_PRICE_MSG);
                return priceNum;
            } catch (CustomException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.printf(Constants.NAN_PRICE_MSG, price);
            }
        } while (true);
    }
}
