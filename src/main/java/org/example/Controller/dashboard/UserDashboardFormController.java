package org.example.Controller.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserDashboardFormController {
    public AnchorPane ancMain;

    public void btnBookinOnAction(ActionEvent actionEvent) throws IOException {
        ancMain.getChildren().clear();
        ancMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/UserBookinForm.fxml")));

    }

    public void btnHistoryOnAction(ActionEvent actionEvent) {
    }

    public void btnBranchDetailsOnAction(ActionEvent actionEvent) throws IOException {
        ancMain.getChildren().clear();
        ancMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/UserViewBranchDetails.fxml")));

    }

    public void btnAllBookDetailsOnAction(ActionEvent actionEvent) {
    }
}
