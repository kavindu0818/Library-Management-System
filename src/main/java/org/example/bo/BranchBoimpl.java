package org.example.bo;

import org.example.Entity.Branch;
import org.example.dao.BranchDaoimpl;
import org.example.dto.BranchDto;

public class BranchBoimpl {

    BranchDaoimpl branchDaoimpl = new BranchDaoimpl();
    public boolean branchSave(BranchDto branch) {
        Branch branch1 = new Branch(branch.getBranchId(),branch.getBranchName(),branch.getLocation(),branch.getOpenTime(),branch.getCloseTime(),branch.getoORc());
        boolean isSave = branchDaoimpl.branchSave(branch1);
        return isSave;

    }
}
