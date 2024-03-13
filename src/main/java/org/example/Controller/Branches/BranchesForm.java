package org.example.Controller.Branches;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.Tm.BooksTm;
import org.example.Tm.BranchTm;
import org.example.bo.impl.BranchBoimpl;
import org.example.dto.BranchDto;

import java.util.List;

public class BranchesForm {
    public JFXTextField txtBranchID;
    public JFXTextField txtBranchName;
    public JFXTextField txtBranchLocation;
    public JFXTextField txtOpenTime;
    public JFXTextField txtCloseeTime;
    public TableView tblBranchdetails;
    public TableColumn colBranchId;
    public TableColumn colBranchName;
    public TableColumn colBranchLocation;
    public TableColumn colOpenTime;
    public TableColumn colClosseTime;
    public TableColumn colNow;
    public TextField txtSeaarchBranch;
    public JFXTextField txt2barnchId;
    public JFXTextField txt2BranchName;
    public JFXTextField txt2BranchLoaaction;
    public JFXTextField txt2CloseTime;
    public JFXTextField txt2OpenTime;
    public JFXComboBox cmbBranchNow;

    BranchBoimpl branchBoimpl = new BranchBoimpl();
    ObservableList<BranchTm> oblist = FXCollections.observableArrayList();

    public void initialize(){
        loardBranchDetails();
        setCellValueFactory();
        setValueCmb();
        searchTable();

    }

    private void setValueCmb() {

        ObservableList<String> catogery = FXCollections.observableArrayList("Open","Close");
        cmbBranchNow.setItems(catogery);
    }

    private void setCellValueFactory() {
        colBranchId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBranchName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBranchLocation.setCellValueFactory(new PropertyValueFactory<>("loc"));
        TableColumn<BranchTm, String> openTimeColumn = new TableColumn<>("Open Time");
        colOpenTime.setCellValueFactory(new PropertyValueFactory<>("openT"));
        TableColumn<BranchTm, String> closeTimeColumn = new TableColumn<>("Close Time");
        colClosseTime.setCellValueFactory(new PropertyValueFactory<>("closeT"));
        colNow.setCellValueFactory(new PropertyValueFactory<>("now"));

    }

    public void searchTable(){
        FilteredList<BranchTm> filteredData = new FilteredList<>(oblist, b -> true);

        txtSeaarchBranch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(booksTm -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                String bookId = String.valueOf(booksTm.getId());
                String title = booksTm.getName().toLowerCase();
                String genre = booksTm.getLoc().toLowerCase();

                return bookId.contains(lowerCaseFilter) || title.contains(lowerCaseFilter) || genre.contains(lowerCaseFilter);
            });
        });

        SortedList<BranchTm> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblBranchdetails.comparatorProperty());
        tblBranchdetails.setItems(sortedData);

    }


    private void loardBranchDetails() {


        try {
            List<BranchDto> branchDtoList = branchBoimpl.getAllBranches();

            System.out.println("mama"); // Check if "mama" is printed

            if (branchDtoList != null) {
                //  System.out.println("Number of books: " + bookDtoList.size()); // Print the number of books in the list
                for (BranchDto branchDto : branchDtoList) {
                    oblist.add(new BranchTm(branchDto.getBranchId(),branchDto.getBranchName(),branchDto.getLocation(),branchDto.getOpenTime(),branchDto.getCloseTime(),branchDto.getoORc()));
                }

                tblBranchdetails.setItems(oblist);
                // tblbooksView.refresh();
            } else {
                System.out.println("The list of books is null.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace to see if there's an exception
            throw new RuntimeException(e);
        }
    }

    public void btnSSubmitOnAction(ActionEvent actionEvent) {
        String id = txtBranchID.getText();
        String branchName = txtBranchName.getText();
        String location = txtBranchLocation.getText();
        String openTime = txtOpenTime.getText();
        String closeTime = txtCloseeTime.getText();
        String now = "Active";

        var branch = new BranchDto(id,branchName,location,openTime,closeTime,now);

        boolean isSave = branchBoimpl.branchSave(branch);

        clearField2();
    }

    public void btnSearchBranchOnAction(ActionEvent actionEvent) {
        String id = txtSeaarchBranch.getText();

        try {
            List<BranchDto> branch = branchBoimpl.getSearchBranchDetails(id);

            for (BranchDto branchDto:branch){

                txt2barnchId.setText(branchDto.getBranchId());
                txt2BranchName.setText(branchDto.getBranchName());
                txt2BranchLoaaction.setText(branchDto.getLocation());
                txt2OpenTime.setText(branchDto.getOpenTime());
                txt2CloseTime.setText(branchDto.getCloseTime());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void btnDeleteBranchOnAction(ActionEvent actionEvent) {
        String id = txt2barnchId.getText();

        boolean isDelete = branchBoimpl.deleteBarnch(id);

        clearField1();

    }

    public void btnBranchUpdateOnAction(ActionEvent actionEvent) {
        String id = txt2barnchId.getText();
        String name = txt2BranchName.getText();
        String location = txt2BranchLoaaction.getText();
        String openT = txt2OpenTime.getText();
        String closeT = txt2CloseTime.getText();
        String now = (String) cmbBranchNow.getValue();

        var branch = new BranchDto(id,name,location,openT,closeT,now);

        boolean isUpdate = branchBoimpl.updateBranch(branch);
        clearField1();
    }

    public void clearField1(){
        txt2barnchId.clear();
        txt2BranchName.clear();
        txt2BranchLoaaction.clear();
        txt2OpenTime.clear();
        txt2CloseTime.clear();
    }

    public void clearField2(){
        txtBranchID.clear();
        txtBranchName.clear();
        txtBranchLocation.clear();
        txtOpenTime.clear();
        txtCloseeTime.clear();
    }
}
