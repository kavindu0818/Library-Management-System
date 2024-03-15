import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.example.Tm.AdminHistoryTm;
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

    public void initialize(){
        loardBranchDetails();
        setCellValueFactory();
    }

    public void btnSearchBookOnAction(ActionEvent actionEvent) {
    }
    private void setCellValueFactory() {
            colBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colBookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
            colBookingDate.setCellValueFactory(new PropertyValueFactory<>("bDate"));
            colHandOverDate.setCellValueFactory(new PropertyValueFactory<>("hDate"));
            colCustomerId.setCellValueFactory(new PropertyValueFactory<>("cId"));
            colCusstomerName.setCellValueFactory(new PropertyValueFactory<>("cName"));


    }
        private void loardBranchDetails() {
            ObservableList<AdminHistoryTm> oblist = FXCollections.observableArrayList();

            try {


                List<HistoryDto> historyDtoList = historyBoimpl.getAllHistory();

                System.out.println("mama"); // Check if "mama" is printed

                if (historyDtoList != null) {
                    //  System.out.println("Number of books: " + bookDtoList.size()); // Print the number of books in the list
                    for (HistoryDto historyDto : historyDtoList) {
//                        String id = historyDto.getCusId();
//                        int userId = Integer.parseInt(id);
//
//                        UserDto userDto = userBoimpl.getUser(userId);

                        String name ="Null"; //userDto.getFullName();

                        oblist.add(new AdminHistoryTm(historyDto.getBookId(),historyDto.getTitle(),historyDto.getBookingDate(),historyDto.getHandOverDate(),historyDto.getCusId(),name));
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

