package org.example.bo.impl;

import org.example.Entity.Branch;
import org.example.bo.BranchBo;
import org.example.dao.BookDao;
import org.example.dao.BranchDao;
import org.example.dao.Custome.DAOFactory;
import org.example.dao.impl.BranchDaoimpl;
import org.example.dto.BranchDto;

import java.util.ArrayList;
import java.util.List;

public class BranchBoimpl implements BranchBo {

   // BranchDaoimpl branchDaoimpl = new BranchDaoimpl();
    BranchDao branchDaoimpl = (BranchDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BRANCH);

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
    public String getLastBranchId() {
        return branchDaoimpl.getLastBookId();
    }

    @Override
    public int getBarnchCount() {
        int set= branchDaoimpl.getCount();
        return set;
    }
}
