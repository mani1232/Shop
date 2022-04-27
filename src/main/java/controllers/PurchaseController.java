package controllers;

import models.Purchase;
import utils.Rounder;
import views.PurchaseView;

public class PurchaseController {

    Purchase model;
    PurchaseView view;

    // Конструктор
    public PurchaseController(Purchase model, PurchaseView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {

        view.getInputs();

        String name = model.getClientName();

        double paymentInitial = model.calculatePayment(
                model.getQuantity(), model.getPrice()
        );
        String paymentInitialRounded = Rounder.roundValue(paymentInitial);

        double discount = model.calculateDiscount(paymentInitial);
        String discountRounded = Rounder.roundValue(discount);

        String paymentRounded = Rounder.roundValue(
                model.calculatePayment(paymentInitial, discount)
        );

        String output = "------------------------------\n" +
                "Client name: " + name + "\n" +
                "Purchase amount (USD): " + paymentInitialRounded + "\n" +
                "Discount amount (USD): " + discountRounded + "\n" +
                "For payment (USD): " + paymentRounded;

        view.getOutput(output);
    }
}
