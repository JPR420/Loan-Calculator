package edu.farmingdale.csc311_loan;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.EventListener;

public class HelloController {

    @FXML
    private Label annualInterestLabel;
    @FXML
    private Label numYearsLabel;
    @FXML
    private Label loanAmountLabel;
    @FXML
    private Label monthlyPaymentLabel;
    @FXML
    private Label totalPaymentLabel;

    @FXML
    private TextField loanTextField;
    @FXML
    private TextField yearTextField;
    @FXML
    private TextField annualTextField;

    @FXML
    private Label monthlyPaymentResultLabel;
    @FXML
    private Label totalPaymentResultLabel;

    @FXML
    private Button calculateButton;

    public void calculate(ActionEvent actionEvent) {
            try {
                double loanAmount = Double.parseDouble(loanTextField.getText());
                double annualInterestRate = Double.parseDouble(annualTextField.getText());
                int years = Integer.parseInt(yearTextField.getText());


                double monthlyInterestRate = annualInterestRate / 100 / 12;
                int numberOfPayments = years * 12;


                double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                        / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

                double totalPayment = monthlyPayment * numberOfPayments;

                monthlyPaymentResultLabel.setText(String.format("$%.2f", monthlyPayment));
                totalPaymentResultLabel.setText(String.format("$%.2f", totalPayment));

            } catch (NumberFormatException e) {
                monthlyPaymentResultLabel.setText("Invalid input");
                totalPaymentResultLabel.setText("Invalid input");
            }

    }
}
