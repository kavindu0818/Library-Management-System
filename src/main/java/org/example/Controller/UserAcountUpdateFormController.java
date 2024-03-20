package org.example.Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.Controller.UserLogin.UserLogInSecoundFormController;
import org.example.bo.Custome.BoFactory;
import org.example.bo.UserBo;
import org.example.dto.UserDto;

import java.util.List;

public class UserAcountUpdateFormController {
    public AnchorPane ancAccount;
    public TextField txtPhone;
    public TextField txtuser;
    public TextField txtFullName;
    public TextField txtGmail;
    public TextField txtPassword;

    UserBo userBoimpl = (UserBo) BoFactory.getBOFactory().getBO(BoFactory.BOTypes.USER);
    UserLogInSecoundFormController userLogInSecoundFormController = new UserLogInSecoundFormController();

    public String userName = userLogInSecoundFormController.us;

    public void initialize(){
       setLoardUser();
       setUserId();
    }

    private void setUserId() {
       // userPhone = userLogInSecoundFormController.sendId();
    }

    private void setLoardUser() {
        try {

            System.out.println(userName + "Hi Hi Hi");
            List<UserDto> userDtos = userBoimpl.getSearchUserUpdate(userName);

            for (UserDto userDto : userDtos){
                txtuser.setText(userDto.getUserName());
                int phone = userDto.getPhoneNumber();
                String up = String.valueOf(phone);
                txtPhone.setText(up);
                txtPassword.setText(userDto.getPassword());
                txtFullName.setText(userDto.getFullName());
                txtGmail.setText(userDto.getGmail());

            }
//            txtuser.setText(userDtos.getUserName());
//            int phone = userDtos.getPhoneNumber();
//            String up = String.valueOf(phone);
//            txtPhone.setText(up);
//            txtPassword.setText(userDtos.getPassword());
//            txtFullName.setText(userDtos.getFullName());
//            txtGmail.setText(userDtos.getGmail());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        int phone = Integer.parseInt(txtPhone.getText());
        String user = txtuser.getText();
        String full = txtFullName.getText();
        String gmail = txtGmail.getText();
        String passwrd = txtPassword.getText();

        var us = new UserDto(phone,full,user,passwrd,gmail);

        boolean isUpdate = userBoimpl.setUpdate(us);

        if(isUpdate){
            new Alert(Alert.AlertType.INFORMATION,"Update Account").show();
        }

    }

    public void updateClear(){
        txtuser.clear();
        txtPhone.clear();
        txtFullName.clear();
        txtGmail.clear();
        txtPassword.clear();
    }
}
