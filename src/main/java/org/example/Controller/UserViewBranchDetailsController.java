package org.example.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Tm.BranchTm;
import org.example.bo.impl.BranchBoimpl;
import org.example.dto.BranchDto;

import java.util.List;

public class UserViewBranchDetailsController {
    public TableView tblUserBranchsDetailsView;
    public TableColumn colBranchName;
    public TableColumn colLocation;
    public TableColumn colOpenTime;
    public TableColumn colCloseTime;
    public TableColumn colNow;

    BranchBoimpl branchBoimpl = new BranchBoimpl();
    public void initialize(){
        loardBranchDetails();
        setCellValueFactory();
    }
    private void setCellValueFactory() {
        colBranchName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLocation.setCellValueFactory(new PropertyValueFactory<>("loc"));
        colOpenTime.setCellValueFactory(new PropertyValueFactory<>("openT"));
        colCloseTime.setCellValueFactory(new PropertyValueFactory<>("closeT"));
        colNow.setCellValueFactory(new PropertyValueFactory<>("now"));

    }
    private void loardBranchDetails() {
        ObservableList<BranchTm> oblist = FXCollections.observableArrayList();

        try {
            List<BranchDto> branchDtoList = branchBoimpl.getAllBranches();

            System.out.println("mama"); // Check if "mama" is printed

            if (branchDtoList != null) {
                //  System.out.println("Number of books: " + bookDtoList.size()); // Print the number of books in the list
                for (BranchDto branchDto : branchDtoList) {
                    oblist.add(new BranchTm(branchDto.getBranchId(),branchDto.getBranchName(),branchDto.getLocation(),branchDto.getOpenTime(),branchDto.getCloseTime(),branchDto.getoORc()));
                }

                tblUserBranchsDetailsView.setItems(oblist);
                // tblbooksView.refresh();
            } else {
                System.out.println("The list of books is null.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace to see if there's an exception
            throw new RuntimeException(e);
        }
    }

}
