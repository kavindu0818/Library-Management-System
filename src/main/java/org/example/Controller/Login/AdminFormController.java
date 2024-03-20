package org.example.Controller.Login;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminFormController {
    public AnchorPane root;
    public JFXTextField txtUserName2;
    public JFXTextField txtPassword2;

    String userName ="kavindu";
    String password ="kmw";


    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {
        String us = txtUserName2.getText();
        String up = txtPassword2.getText();

        if (userName.equals(us) && password.equals(up)){
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/AdminDashboardForm.fxml"));
            Scene scene = new Scene(anchorPane);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("DashBoard Manage");
            stage.centerOnScreen();
            stage.show();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Pleace Cheak UserName And Password").show();
        }

    }
}

