package org.example.Controller.UserLogin;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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


    String userName;
    String pas;
    public static String id = "774257738";

    public static int sendId(){
        return Integer.parseInt(id);
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

         userName = txtUserName.getText();
         pas = txtPassword.getText();

        try {
            List<UserDto> userDtos = userBoimpl.getAllUser(pas,userName);

            for (UserDto userDto:userDtos){
                id = String.valueOf(userDto.getPhoneNumber());

            }

            if (userDtos != null){

                AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/UserDashboardForm.fxml"));
                Scene scene = new Scene(anchorPane);
                Stage stage = (Stage) ancUserLogin.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("DashBoard Manage");
                stage.centerOnScreen();
                stage.show();
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
