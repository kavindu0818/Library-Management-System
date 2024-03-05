package org.example.bo;

import org.example.Entity.Branch;
import org.example.dao.BranchDaoimpl;
import org.example.dto.BranchDto;

import java.util.ArrayList;
import java.util.List;

public class BranchBoimpl {

    BranchDaoimpl branchDaoimpl = new BranchDaoimpl();
    public boolean branchSave(BranchDto branch) {
        Branch branch1 = new Branch(branch.getBranchId(),branch.getBranchName(),branch.getLocation(),branch.getOpenTime(),branch.getCloseTime(),branch.getoORc());
        boolean isSave = branchDaoimpl.branchSave(branch1);
        return isSave;

    }

    public List<BranchDto> getAllBranches() {
        List<BranchDto> branchDtoList = new ArrayList<>();
        List<Branch> branchList = branchDaoimpl.getAllBranches();

        for (Branch branch:branchList){
            branchDtoList.add(new BranchDto(branch.getBranchId(),branch.getBranchName(),branch.getLocation(),branch.getOpenTime(),branch.getCloseTime(),branch.getoORc()));

        }
        return branchDtoList;
    }

    public List<BranchDto> getSearchBranchDetails(String id) {
        List<BranchDto> branchDtoList = new ArrayList<>();
        List<Branch> branchList = branchDaoimpl.getSearchBranch(id);

        for (Branch branch:branchList){
            branchDtoList.add(new BranchDto(branch.getBranchId(),branch.getBranchName(),branch.getLocation(),branch.getOpenTime(),branch.getCloseTime(),branch.getoORc()));

        }
        return branchDtoList;

    }

    public boolean updateBranch(BranchDto branch) {
        Branch branch1 = new Branch(branch.getBranchId(),branch.getBranchName(),branch.getLocation(),branch.getOpenTime(),branch.getCloseTime(),branch.getoORc());
        boolean isUpdate = branchDaoimpl.update(branch1);
        return isUpdate;

    }

    public boolean deleteBarnch(String id) {
        boolean isDelete = branchDaoimpl.delete(id);
        return isDelete;
    }
}
