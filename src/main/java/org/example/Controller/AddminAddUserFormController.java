package org.example.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Entity.User;
import org.example.Tm.BooksTm;
import org.example.Tm.BranchTm;
import org.example.Tm.UserTm;
import org.example.bo.impl.UserBoimpl;
import org.example.dto.BookDto;
import org.example.dto.UserDto;
import org.example.regex.Regex;

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
    ObservableList<UserTm> oblist = FXCollections.observableArrayList();

    public void initialize(){
        getAll();
        setCellValueFactory();
        searchTable();
    }

    public void searchTable(){
        FilteredList<UserTm> filteredData = new FilteredList<>(oblist, b -> true);

        txtSearchUser.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(userTm -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                String bookId = String.valueOf(userTm.getPhone());
                String title = userTm.getUserName().toLowerCase();
                String genre = userTm.getPass().toLowerCase();

                return bookId.contains(lowerCaseFilter) || title.contains(lowerCaseFilter) || genre.contains(lowerCaseFilter);
            });
        });

        SortedList<UserTm> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblUserView.comparatorProperty());
        tblUserView.setItems(sortedData);

    }



    private void setCellValueFactory() {
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colFullName.setCellValueFactory(new PropertyValueFactory<>("full"));
        colGmail.setCellValueFactory(new PropertyValueFactory<>("gmail"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("pass"));

    }

    private void getAll() {

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

        if(isCheckValue()){
            int phone = Integer.parseInt(txt2PhoneNumber.getText());
            String fullName = txt2FullName.getText();
            String userName = txt2UserName.getText();
            String password = txt2Password.getText();
            String gmail = txt2Gmail.getText();

            if ( fullName.isEmpty() || userName.isEmpty() || password.isEmpty() || gmail.isEmpty()){
                new Alert(Alert.AlertType.ERROR, "Field Not found").showAndWait();
                return;
            }

            var user = new UserDto(phone,fullName,userName,password,gmail);

            boolean isUpdate = userBoimpl.userUpdate(user);

            if(isUpdate){
                new Alert(Alert.AlertType.INFORMATION,"User Update").show();

            }
            clearText1();
            getAll();
        }
    }

    public void btnUserSubmitOnAction(ActionEvent actionEvent) {

        if(isCheckValue2()) {

            int phoneNumber = Integer.parseInt(txtPhoneNumber.getText());
            String fullName = txtFullName.getText();
            String userName = txtUserName.getText();
            String password = txtPassword.getText();
            String gmail = txtGmail.getText();

            if (fullName.isEmpty() || userName.isEmpty() || password.isEmpty() || gmail.isEmpty()) {
                new Alert(Alert.AlertType.ERROR, "Field Not found").showAndWait();
                return;
            }

            var user = new UserDto(phoneNumber, fullName, userName, password, gmail);

            boolean isSave = userBoimpl.userSave(user);
            getAll();
            clearText();
        }

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

    private boolean isCheckValue() {

        if (!(Regex.getNamePattern().matcher(txt2FullName.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING, "Full Name Not Valid").show();
            return false;
        }

        if (!(Regex.getEmailPattern().matcher(txt2Gmail.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING, "Gmail Not Valid").show();
            return false;
        }

        if (!(Regex.getMobilePattern().matcher(txt2PhoneNumber.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING, "Id Not Valid").show();
            return false;
        }
        return true;
    }

    private boolean isCheckValue2() {

        if (!(Regex.getNamePattern().matcher(txtFullName.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING, "Full Name Not Valid").show();
            return false;
        }

        if (!(Regex.getEmailPattern().matcher(txtGmail.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING, "Gmail Not Valid").show();
            return false;
        }

        if (!(Regex.getMobilePattern().matcher(txtPhoneNumber.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING, "ID Not Valid").show();
            return false;
        }
        return true;
    }



}
