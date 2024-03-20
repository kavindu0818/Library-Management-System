package org.example.bo.impl;

import org.example.Entity.History;
import org.example.Entity.User;
import org.example.bo.HistoryBo;
import org.example.dao.BranchDao;
import org.example.dao.Custome.DAOFactory;
import org.example.dao.impl.HistoryDaoimpl;
import org.example.dto.HistoryDto;
import org.example.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class HistoryBoimpl implements HistoryBo {

    HistoryDaoimpl historyDaoimpl = new HistoryDaoimpl();
    org.example.dao.History branchDaoimpl = (org.example.dao.History) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.HISTORY);
    public List<HistoryDto> getAllHistory() {
        List<HistoryDto> historyDtoList = new ArrayList<>();
        List<History> history = historyDaoimpl.getAllHistory();


        for (History history1 : history) {
            historyDtoList.add(new HistoryDto(history1.getBookId(),history1.getTitle(),history1.getBookingDate(),history1.getHandOverDate(),history1.getCusId(),history1.getHisId()));
        }

        return historyDtoList;
    }

    public List<HistoryDto> getAllHistoryUser(int uId) {
        List<HistoryDto> historyDtoList = new ArrayList<>();
        List<History> history = historyDaoimpl.getAllHistoryUser(uId);


        for (History history1 : history) {
            historyDtoList.add(new HistoryDto(history1.getBookId(),history1.getTitle(),history1.getBookingDate(),history1.getHandOverDate(),history1.getCusId(),history1.getHisId()));
        }

        return historyDtoList;
    }

}
