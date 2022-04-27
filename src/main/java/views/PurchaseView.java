package views;

import models.Purchase;
import utils.Validator;

import java.util.Scanner;

// View
public class PurchaseView {

    Purchase model;
    String title;
    String name;
    int quantity;
    double price;
    Scanner scanner;

    // Конструктор
    public PurchaseView(Purchase model) {
        this.model = model;
    }

    // Ввод данных
    public void getInputs() {

        // Создаем экземпляр Scanner
        scanner = new Scanner(System.in);

        // Ввод и валидация данных

        title = "Client name: ";
        System.out.print(title);
        name = Validator.validateName(scanner);
        model.setClientName(name);

        title = "Quantity of goods (pieces): ";
        System.out.print(title);
        quantity = Validator.validateQuantityInput(scanner);
        model.setQuantity(quantity);

        title = "Price of the goods piece (USD): ";
        System.out.print(title);
        price = Validator.validatePriceInput(scanner);
        model.setPrice(price);

        // Закрываем Scanner
        scanner.close();
    }

    // Вывод данных
    public void getOutput(String output) {
        System.out.println(output);
    }
}
