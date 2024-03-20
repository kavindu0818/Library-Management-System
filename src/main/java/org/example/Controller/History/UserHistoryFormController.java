package org.example.Controller.History;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Controller.UserLogin.UserLogInSecoundFormController;
import org.example.Tm.AdminHistoryTm;
import org.example.Tm.BranchTm;
import org.example.Tm.UserHistoryTm;
import org.example.bo.impl.HistoryBoimpl;
import org.example.dto.BranchDto;
import org.example.dto.HistoryDto;

import java.util.List;

public class UserHistoryFormController {


    public TableColumn colBookId;
    public TableColumn colBookTitle;
    public TableColumn colBookingDate;
    public TableColumn colHandOver;
    public TextField txtSearchBook;
    public TableView tbtUserHistory;

    HistoryBoimpl historyBoimpl = new HistoryBoimpl();
    UserLogInSecoundFormController userLogInSecoundFormController = new UserLogInSecoundFormController();
    ObservableList<UserHistoryTm> oblist = FXCollections.observableArrayList();
    int uId = userLogInSecoundFormController.ph;

    public void initialize() {
        loardBranchDetails();
        setCellValueFactory();
        searchTable();
        setUidValue();
    }

    public void setUidValue() {
        //uId = userLogInSecoundFormController.sendId();
    }


    private void setCellValueFactory() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colBookingDate.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
        colHandOver.setCellValueFactory(new PropertyValueFactory<>("handOverDate"));


    }

    public void searchTable() {
        FilteredList<UserHistoryTm> filteredData = new FilteredList<>(oblist, b -> true);

        txtSearchBook.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(userHistoryTm -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                String bookId = String.valueOf(userHistoryTm.getBookId());
                String title = userHistoryTm.getTitle().toLowerCase();
                String genre = userHistoryTm.getBookingDate().toLowerCase();

                return bookId.contains(lowerCaseFilter) || title.contains(lowerCaseFilter) || genre.contains(lowerCaseFilter);
            });
        });

        SortedList<UserHistoryTm> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tbtUserHistory.comparatorProperty());
        tbtUserHistory.setItems(sortedData);

    }

    private void loardBranchDetails() {

        try {

            System.out.println(uId + "bye");

            List<HistoryDto> historyDtoList = historyBoimpl.getAllHistoryUser(uId);

            System.out.println("mama"); // Check if "mama" is printed

            if (historyDtoList != null) {
                for (HistoryDto historyDto : historyDtoList) {

                    oblist.add(new UserHistoryTm(historyDto.getBookId(), historyDto.getTitle(),historyDto.getBookingDate(),historyDto.getHandOverDate()));
                }

                tbtUserHistory.setItems(oblist);

            } else {
                System.out.println("The list of books is null.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace to see if there's an exception
            throw new RuntimeException(e);

        }
    }
}
