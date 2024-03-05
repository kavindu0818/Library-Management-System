package org.example.Controller.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminDashboardForm {
    public AnchorPane AncMain;

    public void btnBookFormOnAction(ActionEvent actionEvent) throws IOException {
        AncMain.getChildren().clear();
        AncMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/BookForm.fxml")));

    }

    public void btnBranchFormOnAction(ActionEvent actionEvent) throws IOException {
        AncMain.getChildren().clear();
        AncMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/BranchesForm.fxml")));

    }

    public void btnDashBoardOnAction(ActionEvent actionEvent) {
    }
}
