package org.example.Controller.Book;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import org.example.bo.BookBo;
import org.example.bo.Custome.BoFactory;
import org.example.bo.impl.BookBoimpl;
import org.example.dto.BookDto;
import org.example.regex.Regex;

public class AddBookFormController {
    public AnchorPane AncAddBook;
    public JFXTextField txtbookId;
    public JFXTextField txtBookTitle;
    public JFXTextField txtBookAuthor;
    public JFXComboBox cmbCatougery;
    public TextArea txtStatus;


    BookBo  bookBoimpl = (BookBo) BoFactory.getBOFactory().getBO(BoFactory.BOTypes.BOOK);


    public void initialize(){

        setValueCmb();
        setBookId();
    }

    public void setBookId(){
        txtbookId.setText(splitBooksId(bookBoimpl.getLastBookId()));
    }

    private static String splitBooksId(String currentUserId) {
        if(currentUserId != null) {
            String[] split = currentUserId.split("B0");

            int id = Integer.parseInt(split[1]);
            id++;
            if(id < 10) {
                return "B00" + id;
            } else if (id < 100) {
                return "B0" + id;
            } else {
                return "B" + id;
            }
        } else {
            return "B001";
        }
    }


    public void btnBookSubmitOnAction(ActionEvent actionEvent) {

        if (isCheckValue()) {

            String id = txtbookId.getText();
            String title = txtBookTitle.getText();
            String author = txtBookAuthor.getText();
            String cat = (String) cmbCatougery.getValue();
            String des = txtStatus.getText();

            if (id.isEmpty() || title.isEmpty() || author.isEmpty() || cat.isEmpty() || des.isEmpty()){
                new Alert(Alert.AlertType.ERROR, "Field Not found").showAndWait();
                return;
            }

            var book = new BookDto(id, title, author, cat, des);

            boolean isSave = bookBoimpl.saveBook(book);

            if (isSave){
                new Alert(Alert.AlertType.INFORMATION,"Save Book").show();

            }


            clearField();
            setBookId();
            ;

        }
    }

    private boolean isCheckValue() {

        if (!(Regex.getNamePattern().matcher(txtBookTitle.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING, "Title Not Valid").show();
            return false;
        }

        if (!(Regex.getNamePattern().matcher(txtBookAuthor.getText()).matches())) {
            new Alert(Alert.AlertType.WARNING, "Author Not Valid").show();
            return false;
        }
       return true;
    }
    public void clearField(){
        txtBookTitle.clear();
        txtBookAuthor.clear();
        txtStatus.clear();

    }

    private void setValueCmb() {
        //ComboBox<String> comboBox = new ComboBox<>();

        ObservableList<String> catogery = FXCollections.observableArrayList("Kids","Education");

        cmbCatougery.setItems(catogery);
    }
}
