package com.example.casino7;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.util.Random;

public class HelloController {

    @FXML
    private Text winsText;

    @FXML
    private Text losesText;

    @FXML
    private Text megaWinsText;

    @FXML
    private Text num1;

    @FXML
    private Text num2;

    @FXML
    private Text num3;

    @FXML
    private Button startButton;

    private Random random = new Random();
    private int wins = 0;
    private int loses = 0;
    private int megaWins = 0;

    @FXML
    private void clickHandler() {
        int number1 = random.nextInt(2);
        int number2 = random.nextInt(2);
        int number3 = random.nextInt(2);

        num1.setText(Integer.toString(number1));
        num2.setText(Integer.toString(number2));
        num3.setText(Integer.toString(number3));

        updateStats();
    }

    @FXML
    private void updateStats(){
        if (num1.getText().equals(num2.getText()) && num2.getText().equals(num3.getText())) {
            megaWins++;
            megaWinsText.setText("Mega Wins: " + megaWins);
            showAlert("Megaaaaa win!!!!!!!!!!!!!!", "Mega win!");
        } else if (num1.getText().equals(num2.getText()) || num2.getText().equals(num3.getText())) {
            wins++;
            winsText.setText("Wins: " + wins);
        } else {
            loses++;
            losesText.setText("Loses: " + loses);
        }
    }

    @FXML
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        Text contentText = (Text) alert.getDialogPane().lookup(".content.text");
        alert.getDialogPane().setStyle(
                "-fx-background-color: black;" +
                        "-fx-text-fill: #b01409 !important;" +
                        "-fx-font-size: 25px;" +
                        "-fx-font-weight: bold;"
        );

        alert.showAndWait();
    }
}