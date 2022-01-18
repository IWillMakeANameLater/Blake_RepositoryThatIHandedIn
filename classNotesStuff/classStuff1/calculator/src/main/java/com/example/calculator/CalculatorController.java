package com.example.calculator;

import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.Button;

import com.example.calculator.calcAction;

public class CalculatorController {

    //Fields
    private String currentNumber = "0";
    private ArrayList<calcAction> calculatorActionLog = new ArrayList<>();

    //Set up elements
    @FXML
    private Label display;

    @FXML
    private Label errorDisplay;

    @FXML
    private Button buttonCLEAR;

    @FXML
    private Button buttonDEL;

    @FXML
    private Button buttonSOLVE;

    @FXML
    private Button buttonSubtract;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDivide;

    @FXML
    private Button buttonMultiply;

    @FXML
    private Button buttonDecimal;

    @FXML
    private Button button00;

    @FXML
    private Button button01;

    @FXML
    private Button button02;

    @FXML
    private Button button03;

    @FXML
    private Button button04;

    @FXML
    private Button button05;

    @FXML
    private Button button06;

    @FXML
    private Button button07;

    @FXML
    private Button button08;

    @FXML
    private Button button09;

    //Handling number buttons
    private void insertNum(int num){
        if(currentNumber.length() < 9){
            char firstChar = currentNumber.charAt(0);
            if (firstChar == '0' && currentNumber.length() == 1){
                currentNumber = ""+num;
            } else {
                currentNumber += num;
            }
            updateResult();
        }
    }

    public void on0(){
        insertNum(0);
    }

    public void on1(){
        insertNum(1);
    }

    public void on2(){
        insertNum(2);
    }

    public void on3(){
        insertNum(3);
    }

    public void on4(){
        insertNum(4);
    }

    public void on5(){
        insertNum(5);
    }

    public void on6(){
        insertNum(6);
    }

    public void on7(){
        insertNum(7);
    }

    public void on8(){
        insertNum(8);
    }

    public void on9(){
        insertNum(9);
    }

    //Handling operation buttons

    public void onAdd(ActionEvent actionEvent){
        saveNumber(this.calculatorActionLog.size());
        saveOperation(this.calculatorActionLog.size(), "+");
        clearNumber();
    }

    public void onSubtract(ActionEvent actionEvent){
        saveNumber(this.calculatorActionLog.size());
        saveOperation(this.calculatorActionLog.size(), "-");
        clearNumber();
    }

    public void onMultiply(ActionEvent actionEvent){
        saveNumber(this.calculatorActionLog.size());
        saveOperation(this.calculatorActionLog.size(), "*");
        clearNumber();
    }

    public void onDivide(ActionEvent actionEvent){
        saveNumber(this.calculatorActionLog.size());
        saveOperation(this.calculatorActionLog.size(), "/");
        clearNumber();
    }

    //Handling control buttons

    public void onCLEAR(ActionEvent actionEvent){
        clearCalculation();
    }

    public void onDEL(ActionEvent actionEvent){
        if (currentNumber.length() > 1){
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            updateResult();
        } else {
            clearNumber();
        }
    }

    public void onSOLVE(ActionEvent actionEvent){
        saveNumber(calculatorActionLog.size());
        attemptCalculation: try{
            for(int i=0; i<calculatorActionLog.size(); i++){
                calcAction currentAction = calculatorActionLog.get(i);
                if(currentAction.getActionType() == calcAction.ACTIONTYPE_OPERATOR){
                    calcAction firstNumber = calculatorActionLog.get(i-1);
                    calcAction secondNumber = calculatorActionLog.get(i+1);
                    System.out.println("------------------");
                    System.out.println(firstNumber);
                    System.out.println(currentAction);
                    System.out.println(secondNumber);
                    if (firstNumber.getActionType() == calcAction.ACTIONTYPE_NUM && secondNumber.getActionType() == calcAction.ACTIONTYPE_NUM){
                        Double firstDouble = Double.parseDouble(firstNumber.getValue());
                        Double secondDouble = Double.parseDouble(secondNumber.getValue());
                        Double result = 0.0;
                        switch(currentAction.getValue()){
                            case "+": {
                                result = firstDouble + secondDouble;
                                break;
                            }
                            case "-": {
                                result = firstDouble - secondDouble;
                                break;
                            }
                            case "*": {
                                result = firstDouble * secondDouble;
                                break;
                            }
                            case "/": {
                                result = firstDouble / secondDouble;
                                if (Double.isInfinite(result) || Double.isNaN(result)){
                                    showError("Invalid division by zero");
                                    clearCalculation();
                                    break attemptCalculation;
                                }
                                break;
                            }
                        }
                        calcAction savedResult = new calcAction(calcAction.ACTIONTYPE_NUM, ""+result);
                        calculatorActionLog.add(i-1, savedResult);
                        calculatorActionLog.remove(firstNumber);
                        calculatorActionLog.remove(secondNumber);
                        calculatorActionLog.remove(currentAction);
                        i = calculatorActionLog.indexOf(savedResult);
                        System.out.println(savedResult);
                        System.out.println("------------------");
                    }
                }
            }
            currentNumber = "" + calculatorActionLog.get(0).getValue();
            updateResult();
            calculatorActionLog.clear();
            showError("");
        } catch (Exception e){
            showError("Something went wrong trying to calculate");
            clearCalculation();
        }
    }

    // Handling Decimal Button

    public void onDecimal(ActionEvent actionEvent){
        if (currentNumber.indexOf('.') == -1){
            currentNumber += '.';
            updateResult();
        }
    }

    // Updating text labels

    private void updateResult(){
        display.setText(this.currentNumber);
    }

    private void showError(String text){
        errorDisplay.setText(text);
    }

    // Misc Methods

    private void saveNumber(int saveSpot){
        calcAction savedNumber = new calcAction(calcAction.ACTIONTYPE_NUM, this.currentNumber);
        currentNumber = "";
        this.calculatorActionLog.add(saveSpot, savedNumber);
    }

    private void saveOperation(int saveSpot, String operatorType){
        calcAction savedOperator = new calcAction(calcAction.ACTIONTYPE_OPERATOR, operatorType);
        this.calculatorActionLog.add(saveSpot, savedOperator);
    }

    private void clearNumber(){
        this.currentNumber = "0";
        updateResult();
    }

    private void clearCalculation(){
        this.calculatorActionLog.clear();
        clearNumber();
    }

}