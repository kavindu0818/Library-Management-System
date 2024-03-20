package org.example.Controller.UserLogin;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import org.example.bo.Custome.BoFactory;
import org.example.bo.UserBo;
import org.example.bo.impl.UserBoimpl;
import org.example.dto.UserDto;

public class UserRegistrationFormController {

    public JFXTextField txtFullName;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;
    public JFXTextField txtEmail;
    public JFXTextField txtPhoneNumber;
    public AnchorPane ancRegistration;

    UserBo userBoimpl = (UserBo) BoFactory.getBOFactory().getBO(BoFactory.BOTypes.USER);

    public void btnRegistrationSubmitOnAction(ActionEvent actionEvent) {
        int id = Integer.parseInt(txtPhoneNumber.getText());
        String name = txtFullName.getText();
        String user = txtUserName.getText();
        String password = txtPassword.getText();
        String email = txtEmail.getText();

        var us = new UserDto(id,name,user,password,email);

        boolean isSave = userBoimpl.userSave(us);

        if(isSave){
            new Alert(Alert.AlertType.INFORMATION,"Register Ok!").show();

        }
    }
}
