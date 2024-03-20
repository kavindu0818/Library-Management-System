package org.example.Controller.Booking;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Controller.UserLogin.UserLogInSecoundFormController;
import org.example.Entity.User;
import org.example.Tm.BookHandOverTm;
import org.example.Tm.BookingTm;
import org.example.bo.BookBo;
import org.example.bo.BookHandOverBo;
import org.example.bo.Custome.BoFactory;
import org.example.bo.UserBo;
import org.example.bo.impl.BookBoimpl;
import org.example.bo.impl.BookHandOverimpl;
import org.example.bo.impl.TransactionBussiness;
import org.example.bo.impl.UserBoimpl;
import org.example.dto.BookDto;
import org.example.dto.BookHandOverDto;
import org.example.dto.UserDto;

import java.time.LocalDate;
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


    BookBo bookBoimpl = (BookBo) BoFactory.getBOFactory().getBO(BoFactory.BOTypes.BOOK);
    UserLogInSecoundFormController userLogInSecoundFormController = new UserLogInSecoundFormController();
    BookHandOverBo bookHandOverimpl = (BookHandOverBo) BoFactory.getBOFactory().getBO(BoFactory.BOTypes.BOOKHANDOVER);
    UserBo userBoimpl = (UserBo) BoFactory.getBOFactory().getBO(BoFactory.BOTypes.USER);

   // UserBoimpl userBoimpl  = new UserBoimpl();
    public int userId = userLogInSecoundFormController.ph;
    ObservableList<BookingTm> oblist = FXCollections.observableArrayList();
    ObservableList<BookHandOverTm> oblist1 = FXCollections.observableArrayList();

    TransactionBussiness transaction = new TransactionBussiness();



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
                    Button button = new Button("Hand Over");
                    button.setOnAction(event -> handleButtonClickBook(bookHandOverDto, oblist1));

                    oblist1.add(new BookHandOverTm(bookHandOverDto.getId(),bookHandOverDto.getTitle(),bookHandOverDto.getAutour(),bookHandOverDto.getBookingDate(),bookHandOverDto.getHandOverDate(),button));
                    button.getStyleClass().add("btn");
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
                    Button button = new Button("Booking");
                    button.setOnAction(event -> handleButtonClick(bookDto, oblist));

                    oblist.add(new BookingTm(bookDto.getId(),bookDto.getTitle(),bookDto.getAuthor(),bookDto.getCatougery(),bookDto.getStatus(),button));
                    button.getStyleClass().add("btn1");                }

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

        String bookId = bookHandOverDto.getId();
        String title = bookHandOverDto.getTitle();
        int id = userId;
        String uId = String.valueOf(id);
        String bookD = bookHandOverDto.getBookingDate();
        String booKH = bookHandOverDto.getHandOverDate();
        String bookingId = splitBooksId(transaction.getLastBranchId());

        transaction.sendTransaction(bookId,title,uId,bookD,booKH,bookingId);

    }
    private static String splitBooksId(String currentUserId) {
        if (currentUserId != null) {
            String[] split = currentUserId.split("UH00");

            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) {
                return "UH00" + id;
            } else if (id < 100) {
                return "UH0" + id;
            } else {
                return "UH" + id;
            }
        } else {
            return "UH001";
        }
    }
    private void handleButtonClick(BookDto bookDto, ObservableList<BookingTm> oblist) {

        oblist.removeIf(bookingTm -> bookingTm.getId() == bookDto.getId());

      String id = bookDto.getId();
      String title = bookDto.getTitle();
      String author = bookDto.getAuthor();

        long millis=System.currentTimeMillis();
        java.sql.Date bo=new java.sql.Date(millis);

        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.plusDays(14);
        java.sql.Date returnDate = java.sql.Date.valueOf(futureDate);


        String bookDate = String.valueOf(currentDate);
      String hanDate = String.valueOf(futureDate);

        UserDto userDto = userBoimpl.getUser(userId);

        if (userDto != null){
            System.out.println(userDto.getPhoneNumber() + " " + userDto.getUserName() + " Hey Hey");

        }else {
            System.out.println("Not Value");
        }

        User user = new User(userDto.getPhoneNumber(),userDto.getFullName(),userDto.getUserName(),userDto.getPassword(),userDto.getGmail());

        System.out.println(userDto.getPhoneNumber() + " " + userDto.getUserName() + " Hey Hey");

      var booking = new BookHandOverDto(id,title,author, bookDate,hanDate,user.getPhoneNumber());

      boolean isSave = bookHandOverimpl.BookingHandSave(booking,user);

        tblBookinView.setItems(oblist);

    }


}
