package org.example.Controller.Book;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import org.example.bo.BookBoimpl;
import org.example.dto.BookDto;

public class AddBookFormController {
    public AnchorPane AncAddBook;
    public JFXTextField txtbookId;
    public JFXTextField txtBookTitle;
    public JFXTextField txtBookAuthor;
    public JFXComboBox cmbCatougery;
    public TextArea txtStatus;

    BookBoimpl bookBoimpl = new BookBoimpl();

    public void btnBookSubmitOnAction(ActionEvent actionEvent) {

        String id = txtbookId.getText();
        String title = txtBookTitle.getText();
        String author = txtBookAuthor.getText();
        String cat = (String) cmbCatougery.getValue();
        String des = txtStatus.getText();

        var book = new BookDto(id,title,author,cat,des);

        boolean isSave = bookBoimpl.saveBook(book);




    }
}
