package org.example.Controller.dashboard;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDashboardFormController {
    public AnchorPane ancMain;
    public Label lblTime;
    public Label lblDate;

    public void initialize() throws IOException {
        setDashBoard();
        Time();
        date();
    }

    public void setDashBoard() throws IOException {
        ancMain.getChildren().clear();
        ancMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/UserDashBoardMainForm.fxml")));

    }

    public void btnBookinOnAction(ActionEvent actionEvent) throws IOException {
        ancMain.getChildren().clear();
        ancMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/UserBookinForm.fxml")));

    }

    public void btnHistoryOnAction(ActionEvent actionEvent) throws IOException {
        ancMain.getChildren().clear();
        ancMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/UserHistoryForm.fxml")));

    }

    public void btnBranchDetailsOnAction(ActionEvent actionEvent) throws IOException {
        ancMain.getChildren().clear();
        ancMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/UserViewBranchDetails.fxml")));

    }

    public void btnAllBookDetailsOnAction(ActionEvent actionEvent) throws IOException {
        ancMain.getChildren().clear();
        ancMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/ViewBookDetailsUser.fxml")));

    }

    public void btnDashBoardOnAction(ActionEvent actionEvent) throws IOException {
        ancMain.getChildren().clear();
        ancMain.getChildren().add(FXMLLoader.load(getClass().getResource("/view/UserDashBoardMainForm.fxml")));

    }

    public void btnChangeOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/UserAcountUpdateForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Book");
        stage.centerOnScreen();
        stage.show();
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
