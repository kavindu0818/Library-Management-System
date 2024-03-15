package org.example.bo.impl;

import org.example.Entity.History;
import org.example.Entity.User;
import org.example.dao.impl.HistoryDaoimpl;
import org.example.dto.HistoryDto;
import org.example.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class HistoryBoimpl {

    HistoryDaoimpl historyDaoimpl = new HistoryDaoimpl();
    public List<HistoryDto> getAllHistory() {
        List<HistoryDto> historyDtoList = new ArrayList<>();
        List<History> history = historyDaoimpl.getAllHistory();


        for (History history1 : history) {
            historyDtoList.add(new HistoryDto(history1.getHisId(),history1.getBookId(),history1.getTitle(),history1.getBookingDate(),history1.getHandOverDate(),history1.getCusId()));
        }

        return historyDtoList;
    }
}
