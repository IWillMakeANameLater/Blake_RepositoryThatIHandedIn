package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    //Fields
    private double calcValue = 0;

    //Set up elements
    @FXML
    private Label display;

    @FXML
    private Label errorDisplay;

    @FXML
    private Button buttonCLEAR;

    @FXML
    private Button buttonSubtract;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDivide;

    @FXML
    private Button buttonMultiply;

    @FXML
    private TextField textField_Add;

    @FXML
    private TextField textField_Subtract;

    @FXML
    private TextField textField_Multiply;

    @FXML
    private TextField textField_Divide;

    //Handling operation buttons
    public void onAdd(ActionEvent actionEvent){
        String inputString = textField_Add.getText();
        try {
            calcValue += Double.parseDouble(inputString);
            updateResult();
        }
        catch (Exception error) {
            showError("Could not convert input into a valid double");
        }
    }

    public void onMultiply(ActionEvent actionEvent){
        String inputString = textField_Multiply.getText();
        try {
            calcValue *= Double.parseDouble(inputString);
            updateResult();
        }
        catch (Exception error) {
            showError("Could not convert input into a valid double");
        }
    }

    public void onSubtract(ActionEvent actionEvent){
        String inputString = textField_Subtract.getText();
        try {
            calcValue -= Double.parseDouble(inputString);
            updateResult();
        }
        catch (Exception error) {
            showError("Could not convert input into a valid double");
        }
    }

    public void onDivide(ActionEvent actionEvent){
        String inputString = textField_Divide.getText();
        double previousValue = calcValue;
        try {
            double divideValue = Double.parseDouble(inputString);
            calcValue = calcValue / divideValue;
            if(Double.isNaN(calcValue) || Double.isInfinite(calcValue)){
                calcValue = previousValue;
                showError("Cannot divide by zero");
            }else{
                updateResult();
            }
        }
        catch (Exception error) {
            showError("Could not convert input into a valid double");
        }
    }

    //Handling clear button

    public void onCLEAR(ActionEvent actionEvent){
        calcValue = 0;
        updateResult();
    }

    // Updating text labels

    private void updateResult(){
        display.setText(""+calcValue);
        showError("");
    }

    private void showError(String text){
        errorDisplay.setText(text);
    }

}