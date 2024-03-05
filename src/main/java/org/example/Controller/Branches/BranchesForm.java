package org.example.Controller.Branches;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.bo.BranchBoimpl;
import org.example.dto.BranchDto;

import javax.sql.rowset.serial.SerialStruct;
import java.sql.Time;

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

    public void initialize(){

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
    }

    public void btnSearchBranchOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteBranchOnAction(ActionEvent actionEvent) {
    }

    public void btnBranchUpdateOnAction(ActionEvent actionEvent) {
    }
}
