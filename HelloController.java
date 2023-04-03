package com.fsttanger.khawlaproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField enterTextField;
    @FXML
    private PasswordField enterPasswordField;

    public void loginButtonOnAction(ActionEvent event){
        if (enterTextField.getText().isBlank() == false && enterPasswordField.getText().isBlank() == false){
            ValidateLogin();
        }
        else {
            loginMessageLabel.setText("please enter username and password");
        }
    }
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    public void ValidateLogin(){
    DataBaseConnection connectNow = new DataBaseConnection();
    Connection connectDB = connectNow.getConnection();
    String verifyLogin ="SELECT count(1) FROM user_account WHERE username= '"+ enterTextField.getText()+ "'AND password"+enterPasswordField.getText()+ "'";
    try {
        Statement statement = connectDB.createStatement();
        ResultSet queryResult= statement.executeQuery(verifyLogin);
        while (queryResult.next()) {
            if (queryResult.getInt(1)==1) {
             loginMessageLabel.setText("congratulations!");
            } else {
                loginMessageLabel.setText("invalid login. PLEASE try again");
            }
        }

    }catch (Exception e) {
     e.printStackTrace();
     e.getCause();
    }
}
}