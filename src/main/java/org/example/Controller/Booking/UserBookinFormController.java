package org.example.Controller.Booking;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import org.example.Controller.UserLogin.UserLogInSecoundFormController;
import org.example.Entity.User;
import org.example.Tm.BookHandOverTm;
import org.example.Tm.BookingTm;
import org.example.Tm.BooksTm;
import org.example.bo.impl.BookBoimpl;
import org.example.bo.impl.BookHandOverimpl;
import org.example.bo.impl.UserBoimpl;
import org.example.dto.BookDto;
import org.example.dto.BookHandOverDto;
import org.example.dto.UserDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
    UserBoimpl userBoimpl = new UserBoimpl();

    int userId = userLogInSecoundFormController.sendId();
    ObservableList<BookingTm> oblist = FXCollections.observableArrayList();
    ObservableList<BookHandOverTm> oblist1 = FXCollections.observableArrayList();



    public void initialize(){
      loadAllBooks();
      setCellValueFactory();
        setCellValueFactoryBookHandOver();
  }

    private void setCellValueFactory() {
        colBookingId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBookingcolTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colBookingAuthour.setCellValueFactory(new PropertyValueFactory<>("authour"));
        colBookingCatougery.setCellValueFactory(new PropertyValueFactory<>("catougery"));
        colBookinStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        colBookingButton.setCellValueFactory(new PropertyValueFactory<>("button"));

    }

    private void setCellValueFactoryBookHandOver() {
        colHandOverId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colHandOverTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colHandOverAutour.setCellValueFactory(new PropertyValueFactory<>("autour"));
        colHandOverBookingDate.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        colHandOverOverDate.setCellValueFactory(new PropertyValueFactory<>("HandOverdate"));
        colHandOverButton.setCellValueFactory(new PropertyValueFactory<>("button"));

    }

    private void loadAllBooks() {

        List<BookHandOverDto> bookHandOverDtos = bookHandOverimpl.getAllHandOverBook();

        try {
            if (bookHandOverDtos != null) {

                for (BookHandOverDto bookHandOverDto : bookHandOverDtos) {
                    Button button = new Button("Button");
                    button.setOnAction(event -> handleButtonClickBook(bookHandOverDto, oblist1));

                    oblist1.add(new BookHandOverTm(bookHandOverDto.getId(),bookHandOverDto.getTitle(),bookHandOverDto.getAutour(),bookHandOverDto.getBookingDate(),bookHandOverDto.getHandOverDate(),button));
                }

                tblHandOverBookView.setItems(oblist1);

            } else {
                System.out.println("The list of books is null.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try {
            List<BookDto> bookDtoList = bookBoimpl.getAllBooks();

            System.out.println("mama");

            if (bookDtoList != null) {

                for (BookDto bookDto : bookDtoList) {
                    Button button = new Button("Button");
                    button.setOnAction(event -> handleButtonClick(bookDto, oblist));

                    oblist.add(new BookingTm(bookDto.getId(),bookDto.getTitle(),bookDto.getAuthor(),bookDto.getCatougery(),bookDto.getStatus(),button));
                }

                deleteTableValue();
                tblBookinView.setItems(oblist);

            } else {
                System.out.println("The list of books is null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void deleteTableValue() {
        List<BookingTm> itemsToRemove = new ArrayList<>();

        for (BookingTm bookingTm : oblist) {
            String id = bookingTm.getId();

            for (BookHandOverTm bookHandOverTm : oblist1) {
                String bookId = bookHandOverTm.getId();

                if (bookId.equals(id)) {
                    itemsToRemove.add(bookingTm);
                }
            }
        }

        // Remove the identified items from oblist1
        oblist.removeAll(itemsToRemove);
    }

    private void handleButtonClickBook(BookHandOverDto bookHandOverDto, ObservableList<BookHandOverTm> oblist1) {
        oblist1.removeIf(bookHandOverTm -> bookHandOverTm.getId() == bookHandOverDto.getId());
    }

    private void handleButtonClick(BookDto bookDto, ObservableList<BookingTm> oblist) {

        oblist.removeIf(bookingTm -> bookingTm.getId() == bookDto.getId());

        String bookingDate = null;

        Timeline time = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    bookingDate.repeat(Integer.parseInt(LocalDateTime.now().format(formatter)));
                }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();


      String id = bookDto.getId();
      String title = bookDto.getTitle();
      String author = bookDto.getAuthor();

      String status = bookDto.getStatus();

        UserDto userDto = userBoimpl.getUser(userId);
        User user = new User(userDto.getPhoneNumber(),userDto.getFullName(),userDto.getUserName(),userDto.getPassword(),userDto.getGmail());

      var booking = new BookHandOverDto(id,title,author,bookingDate,status,user.getPhoneNumber());

      boolean isSave = bookHandOverimpl.BookingHandSave(booking,user);

        tblBookinView.setItems(oblist);
    }


}
