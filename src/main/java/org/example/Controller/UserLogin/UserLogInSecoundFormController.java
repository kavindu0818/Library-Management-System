package org.example.Controller.UserLogin;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.Controller.UserAcountUpdateFormController;
import org.example.bo.Custome.BoFactory;
import org.example.bo.UserBo;
import org.example.bo.impl.UserBoimpl;
import org.example.dto.UserDto;

import java.io.IOException;
import java.util.List;

public class UserLogInSecoundFormController {
    public AnchorPane ancUserLogin;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;

    UserBo userBoimpl = (UserBo) BoFactory.getBOFactory().getBO(BoFactory.BOTypes.USER);

  //  UserAcountUpdateFormController userAcountUpdateFormController = new UserAcountUpdateFormController();


    public static String us = "null";
    public static int ph;


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if (txtUserName == null || txtPassword == null || ancUserLogin == null) {
            System.err.println("FXML elements are not properly initialized.");
            return;
        }

        String userName = txtUserName.getText();
        String pas = txtPassword.getText();

        System.out.println(userName + " " + pas);


        try {
           List <UserDto> userDtos = userBoimpl.getAllUser(userName);

           String un = null;

            for (UserDto userDto : userDtos){
                System.out.println(userDto.getPhoneNumber() + "Hi Hi");
                ph = userDto.getPhoneNumber();
                un = userDto.getUserName();
            }


            if (userName.equals(un)) {

                us = userName;

                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/UserDashboardForm.fxml"));
                Scene scene = new Scene(anchorPane);
                Stage stage = (Stage) ancUserLogin.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Dashboard Manage");
                stage.centerOnScreen();
                stage.show();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

