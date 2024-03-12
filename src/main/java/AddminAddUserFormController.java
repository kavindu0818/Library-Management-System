import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Entity.User;
import org.example.Tm.BooksTm;
import org.example.Tm.UserTm;
import org.example.bo.impl.UserBoimpl;
import org.example.dto.BookDto;
import org.example.dto.UserDto;

import java.util.List;

public class AddminAddUserFormController {
    public TextField txtSearchUser;
    public Button btnUserSearchOnAction;
    public TextField txt2FullName;
    public TextField txt2Gmail;
    public TextField txt2PhoneNumber;
    public TextField txt2UserName;
    public TextField txt2Password;
    public Button btnUserUpdateOnAction;
    public TableView tblUserView;
    public TableColumn colPhoneNumber;
    public TableColumn colFullName;
    public TableColumn colGmail;
    public TableColumn colUserName;
    public TableColumn colPassword;
    public JFXTextField txtPhoneNumber;
    public JFXTextField txtFullName;
    public JFXTextField txtGmail;
    public JFXTextField txtUserName;
    public JFXTextField txtPassword;

    UserBoimpl userBoimpl = new UserBoimpl();

    public void initialize(){
        getAll();
        setCellValueFactory();
    }
    private void setCellValueFactory() {
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colFullName.setCellValueFactory(new PropertyValueFactory<>("full"));
        colGmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("pass"));

    }

    private void getAll() {
        ObservableList<UserTm> oblist = FXCollections.observableArrayList();

        try {
            List<UserDto> userDtos = userBoimpl.getAllUserAll();

            System.out.println("mama"); // Check if "mama" is printed

            if (userDtos != null) {
                //  System.out.println("Number of books: " + bookDtoList.size()); // Print the number of books in the list
                for (UserDto userDto : userDtos) {
                    String user = String.valueOf(userDto.getPhoneNumber());
                    oblist.add(new UserTm(user,userDto.getFullName(),userDto.getGmail(),userDto.getUserName(),userDto.getPassword()));

                }

                tblUserView.setItems(oblist);
                // tblbooksView.refresh();
            } else {
                System.out.println("The list of books is null.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace to see if there's an exception
            throw new RuntimeException(e);
        }



    }

    public void btnUserUpdateOnAction(ActionEvent actionEvent) {
        int phone = Integer.parseInt(txt2PhoneNumber.getText());
        String fullName = txt2FullName.getText();
        String userName = txt2UserName.getText();
        String password = txt2Password.getText();
        String gmail = txt2Gmail.getText();

        var user = new UserDto(phone,fullName,userName,password,gmail);

        boolean isUpdate = userBoimpl.userUpdate(user);
        clearText1();
        getAll();
    }

    public void btnUserSubmitOnAction(ActionEvent actionEvent) {
        int phoneNumber = Integer.parseInt(txtPhoneNumber.getText());
        String fullName = txtFullName.getText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        String gmail = txtGmail.getText();

        var user = new UserDto(phoneNumber,fullName,userName,password,gmail);

        boolean isSave = userBoimpl.userSave(user);
        clearText();

    }

    public void btnUserRemoveOnAction(ActionEvent actionEvent) {
        int phone = Integer.parseInt(txt2PhoneNumber.getText());
        String fullName = txt2FullName.getText();
        String userName = txt2UserName.getText();
        String password = txt2Password.getText();
        String gmail = txt2Gmail.getText();

        var user = new UserDto(phone,fullName,userName,password,gmail);

        boolean isDelete = userBoimpl.userDelete(user.getPhoneNumber());
        clearText1();
        getAll();
    }

    public void btnUserSearcOnAction(ActionEvent actionEvent) {
        int user = Integer.parseInt(txtSearchUser.getText());

        try {
            List<UserDto> userDtos = userBoimpl.getSearchUser(user);

            for (UserDto userDto:userDtos){
                txt2PhoneNumber.setText(String.valueOf(userDto.getPhoneNumber()));
                txt2FullName.setText(userDto.getFullName());
                txt2UserName.setText(userDto.getUserName());
                txt2Password.setText(userDto.getPassword());
                txt2Gmail.setText(userDto.getGmail());

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void clearText(){
        txtPassword.clear();
        txtFullName.clear();
        txtGmail.clear();
        txtUserName.clear();
        txtPassword.clear();
    }

    public void clearText1(){
        txt2Password.clear();
        txt2FullName.clear();
        txt2Gmail.clear();
        txt2UserName.clear();
        txt2PhoneNumber.clear();
        txtSearchUser.clear();
    }



}
