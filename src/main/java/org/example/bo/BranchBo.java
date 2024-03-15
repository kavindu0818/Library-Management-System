package org.example.bo;

import org.example.Entity.Branch;
import org.example.bo.Custome.SuperBo;
import org.example.dto.BranchDto;

import java.util.ArrayList;
import java.util.List;

public interface BranchBo extends SuperBo {

    public boolean branchSave(BranchDto branch);

    public List<BranchDto> getAllBranches();

    public List<BranchDto> getSearchBranchDetails(String id);

    public boolean updateBranch(BranchDto branch);

    public boolean deleteBarnch(String id);
}
