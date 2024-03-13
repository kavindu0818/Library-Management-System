package org.example.Controller.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminDashboardForm {
    public AnchorPane AncMain;

    public void initialize() throws IOException {
        dashboard();
    }

    public void dashboard() throws IOException {
        AncMain.getChildren().clear();
        AncMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminDashboardMainForm.fxml")));

    }

    public void btnBookFormOnAction(ActionEvent actionEvent) throws IOException {
        AncMain.getChildren().clear();
        AncMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/BookForm.fxml")));

    }

    public void btnBranchFormOnAction(ActionEvent actionEvent) throws IOException {
        AncMain.getChildren().clear();
        AncMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/BranchesForm.fxml")));

    }

    public void btnDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        AncMain.getChildren().clear();
        AncMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AdminDashboardMainForm.fxml")));

    }

    public void btnBorrowingOnAction(ActionEvent actionEvent) throws IOException {
        AncMain.getChildren().clear();
        AncMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/BorrowingHistoryFrom.fxml")));
    }

    public void btnUserAddOnAction(ActionEvent actionEvent) throws IOException {
        AncMain.getChildren().clear();
        AncMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/AddminAddUserForm.fxml")));

    }
}
