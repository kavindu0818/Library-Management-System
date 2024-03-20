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
import javafx.scene.layout.AnchorPane;
import org.example.Tm.AdminHistoryTm;
import org.example.Tm.BooksTm;
import org.example.Tm.BranchTm;
import org.example.bo.impl.HistoryBoimpl;
import org.example.bo.impl.UserBoimpl;
import org.example.dto.BranchDto;
import org.example.dto.HistoryDto;
import org.example.dto.UserDto;

import java.util.List;

public class BorrowingHistoryFromController {
    public AnchorPane ancBookingHistory;
    public TableView tblBookingHisory;
    public TableColumn colBookId;
    public TableColumn colBookTitle;
    public TableColumn colBookingDate;
    public TableColumn colHandOverDate;
    public TableColumn colCustomerId;
    public TableColumn colCusstomerName;
    public TextField txtSearchBook;

    UserBoimpl userBoimpl = new UserBoimpl();
    HistoryBoimpl historyBoimpl = new HistoryBoimpl();
    ObservableList<AdminHistoryTm> oblist = FXCollections.observableArrayList();

    public void initialize(){
        loardBranchDetails();
        setCellValueFactory();
        searchTable();
    }

    public void btnSearchBookOnAction(ActionEvent actionEvent) {
    }
    private void setCellValueFactory() {
            colBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colBookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colBookingDate.setCellValueFactory(new PropertyValueFactory<>("bookingDate"));
            colHandOverDate.setCellValueFactory(new PropertyValueFactory<>("handOverDate"));
            colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
            colCusstomerName.setCellValueFactory(new PropertyValueFactory<>("customerName"));


    }

    public void searchTable(){
        FilteredList<AdminHistoryTm> filteredData = new FilteredList<>(oblist, b -> true);

        txtSearchBook.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(adminHistoryTm -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                String bookId = String.valueOf(adminHistoryTm.getId());
                String title = adminHistoryTm.getTitle().toLowerCase();
                String genre = adminHistoryTm.getCustomerName().toLowerCase();

                return bookId.contains(lowerCaseFilter) || title.contains(lowerCaseFilter) || genre.contains(lowerCaseFilter);
            });
        });

        SortedList<AdminHistoryTm> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblBookingHisory.comparatorProperty());
        tblBookingHisory.setItems(sortedData);

    }
        private void loardBranchDetails() {

            try {

                List<HistoryDto> historyDtoList = historyBoimpl.getAllHistory();

                System.out.println("mama"); // Check if "mama" is printed

                if (historyDtoList != null) {
                    for (HistoryDto historyDto : historyDtoList) {
//                        String id = historyDto.getCusId();
//                        int userId = Integer.parseInt(id);
//
//                        UserDto userDto = userBoimpl.getUser(userId);

                        String name ="Null"; //userDto.getFullName();

                        oblist.add(new AdminHistoryTm(historyDto.getBookId(),historyDto.getTitle(), historyDto.getBookingDate(), historyDto.getHandOverDate(), historyDto.getCusId(),name));
                    }

                    tblBookingHisory.setItems(oblist);

                } else {
                    System.out.println("The list of books is null.");
                }
            } catch (Exception e) {
                e.printStackTrace(); // Print the stack trace to see if there's an exception
                throw new RuntimeException(e);
            }
        }
    }

