package org.example.Controller.Book;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.Entity.Book;
import org.example.Tm.BooksTm;
import org.example.bo.BookBoimpl;
import org.example.dto.BookDto;

import java.io.IOException;
import java.util.List;

public class BookForm {
    public TableColumn colid;
    public TableColumn colTitle;
    public TableColumn colAuthour;
    public TableColumn colCategory;
    public TableColumn colStatus;
    public TableView tblbooksView;
    public Label lblBookId;
    public Label lblBookTitle;
    public Label lblBookAuthour;
    public Label lblBookCategory;
    public JFXTextArea lblBookDescription;
    public TextField textSeacrhBookTitle;
    public JFXTextField txtBookTitle;
    public JFXTextField txtBookAutour;
    public JFXComboBox cmbBookCatougery;

    BookBoimpl bookBoimpl = new BookBoimpl();


    public void initialize() {
        setCellValueFactory();
        loadAllBooks();
        setValueCmb();
    }

    private void setValueCmb() {
        //ComboBox<String> comboBox = new ComboBox<>();

        ObservableList<String> catogery = FXCollections.observableArrayList("Kids","Education");

        cmbBookCatougery.setItems(catogery);
    }

    private void setCellValueFactory() {
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthour.setCellValueFactory(new PropertyValueFactory<>("author"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void loadAllBooks() {
        ObservableList<BooksTm> oblist = FXCollections.observableArrayList();

        try {
            List<BookDto> bookDtoList = bookBoimpl.getAllBooks();

            System.out.println("mama"); // Check if "mama" is printed

            if (bookDtoList != null) {
              //  System.out.println("Number of books: " + bookDtoList.size()); // Print the number of books in the list
                for (BookDto bookDto : bookDtoList) {
                    oblist.add(new BooksTm(bookDto.getId(), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getCatougery(), bookDto.getStatus()));
                }

                tblbooksView.setItems(oblist);
                // tblbooksView.refresh();
            } else {
                System.out.println("The list of books is null.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace to see if there's an exception
            throw new RuntimeException(e);
        }
    }

    public void btnAddBookOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/View/AddBookForm.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add Book");
        stage.centerOnScreen();
        stage.show();

    }

    public void btnBookUpdateOnAction(ActionEvent actionEvent) {
        String id = lblBookId.getText();
        String title = txtBookTitle.getText();
        String authour = txtBookAutour.getText();
        String cat = (String) cmbBookCatougery.getValue();
        String des = lblBookDescription.getText();

        var book = new BookDto(id,title,authour,cat,des);

        boolean isupdate = bookBoimpl.updateBook(book);

        clearField();

    }

    public void btnBookDeleteOnAction(ActionEvent actionEvent) {
        String id = lblBookId.getText();

        boolean isDelete = bookBoimpl.deleteBook(id);

        clearField();
    }

    public void clearField(){
        txtBookTitle.clear();
        txtBookAutour.clear();
        lblBookDescription.clear();
    }

    public void btnSearchBookOnAction(ActionEvent actionEvent) {
        String book = textSeacrhBookTitle.getText();

        try {
            List<BookDto> bookDtos = bookBoimpl.getSearchBook(book);

            for (BookDto bookDto:bookDtos){
                lblBookId.setText(bookDto.getId());
                txtBookTitle.setText(bookDto.getTitle());
                txtBookAutour.setText(bookDto.getAuthor());
                cmbBookCatougery.setValue(bookDto.getCatougery());
                lblBookDescription.setText(bookDto.getStatus());

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
