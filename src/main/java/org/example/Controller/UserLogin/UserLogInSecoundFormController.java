package org.example.Controller.UserLogin;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLogInSecoundFormController {
    public AnchorPane ancUserLogin;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/UserDashboardForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) ancUserLogin.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("DashBoard Manage");
        stage.centerOnScreen();
        stage.show();
    }
}
