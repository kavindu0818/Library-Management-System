package org.example.Controller.UserLogin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserLoginFormControler {
    public AnchorPane ancloginFormSet;

    public void btnLoginFormSetOnAction(ActionEvent actionEvent) throws IOException {
        ancloginFormSet.getChildren().clear();
        ancloginFormSet.getChildren().add(FXMLLoader.load(getClass().getResource("/view/UserLogInSecoundForm.fxml")));

    }

    public void btnUserRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/UserRegistrationForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Book");
        stage.centerOnScreen();
        stage.show();
    }
}
