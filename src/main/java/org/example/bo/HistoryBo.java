package org.example.bo;

import org.example.Entity.History;
import org.example.bo.Custome.SuperBo;
import org.example.dto.HistoryDto;

import java.util.ArrayList;
import java.util.List;

public interface HistoryBo extends SuperBo {

    public List<HistoryDto> getAllHistory();
}
