package org.example.Controller.dashboard;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.IOException;

public class AdminDashboardForm {
    public AnchorPane AncMain;
    public Label lblTime;
    public Label lblDate;

    public void initialize() throws IOException {
        dashboard();
        Time();
        date();
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

    public void Time() {

        Timeline time = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    lblTime.setText(LocalDateTime.now().format(formatter));
                }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void date() {

        Timeline time = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    lblDate.setText(LocalDateTime.now().format(formatter));
                }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }
}
