package org.example.Controller.Booking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Controller.UserLogin.UserLogInSecoundFormController;
import org.example.Entity.User;
import org.example.Tm.BookingTm;
import org.example.Tm.BooksTm;
import org.example.bo.impl.BookBoimpl;
import org.example.bo.impl.BookHandOverimpl;
import org.example.dto.BookDto;
import org.example.dto.BookHandOverDto;

import java.util.List;

public class UserBookinFormController {

    public TableView tblBookinView;
    public TableColumn colBookingId;
    public TableColumn colBookingcolTitle;
    public TableColumn colBookingAuthour;
    public TableColumn colBookingCatougery;
    public TableColumn colBookinStatus;
    public TableColumn colBookingButton;
    public TableView tblHandOverBookView;
    public TableColumn colHandOverId;
    public TableColumn colHandOverTitle;
    public TableColumn colHandOverAutour;
    public TableColumn colHandOverBookingDate;
    public TableColumn colHandOverOverDate;
    public TableColumn colHandOverButton;


    BookBoimpl bookBoimpl = new BookBoimpl();
    UserLogInSecoundFormController userLogInSecoundFormController = new UserLogInSecoundFormController();
    BookHandOverimpl bookHandOverimpl = new BookHandOverimpl();

    int userId = userLogInSecoundFormController.sendId();


    public void initialize(){
      loadAllBooks();
      setCellValueFactory();
  }

    private void setCellValueFactory() {
        colBookingId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBookingcolTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colBookingAuthour.setCellValueFactory(new PropertyValueFactory<>("authour"));
        colBookingCatougery.setCellValueFactory(new PropertyValueFactory<>("catougery"));
        colBookinStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colBookingButton.setCellValueFactory(new PropertyValueFactory<>("button"));

    }

    private void loadAllBooks() {
        ObservableList<BookingTm> oblist = FXCollections.observableArrayList();

        try {
            List<BookDto> bookDtoList = bookBoimpl.getAllBooks();

            System.out.println("mama");

            if (bookDtoList != null) {

                for (BookDto bookDto : bookDtoList) {
                    Button button = new Button("Button");
                    button.setOnAction(event -> handleButtonClick(bookDto, oblist));

                    oblist.add(new BookingTm(bookDto.getId(),bookDto.getTitle(),bookDto.getAuthor(),bookDto.getCatougery(),bookDto.getStatus(),button));
                }

                tblBookinView.setItems(oblist);

            } else {
                System.out.println("The list of books is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void handleButtonClick(BookDto bookDto, ObservableList<BookingTm> oblist) {

        System.out.println("Button clicked for book: " + bookDto.getTitle());

        oblist.removeIf(bookingTm -> bookingTm.getId() == bookDto.getId());

      String id = bookDto.getId();
      String title = bookDto.getTitle();
      String author = bookDto.getAuthor();
      String catougery = bookDto.getCatougery();
      String status = bookDto.getStatus();

        User user = new User();
        user.setPhoneNumber(userId);

      var booking = new BookHandOverDto(id,title,author,catougery,status,userId);


      boolean isSave = bookHandOverimpl.BookingHandSave(booking);


        System.out.println( "me ena badu "+id+" "+title + " ");




        tblBookinView.setItems(oblist);
    }


}
