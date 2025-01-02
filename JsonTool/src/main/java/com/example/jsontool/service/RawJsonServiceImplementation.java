package com.example.jsontool.service;

import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.exceptions.InvalidJsonException;
import com.example.jsontool.repository.HistoryManager;
import com.example.jsontool.service.command.FormatJsonCommand;
import com.example.jsontool.service.strategy.JsonFormatterContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RawJsonServiceImplementation implements RawJsonService {
    private final HistoryManager historyManager;
    private final JsonFormatterContext formatterContext = new JsonFormatterContext();

    @Autowired
    public RawJsonServiceImplementation(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }
    @Override
    public String formatJson(RawJsonDto rawJsonDto, String formatType) {
        try {
            FormatJsonCommand command = new FormatJsonCommand(rawJsonDto, formatType, formatterContext, historyManager);
            return command.execute();
        } catch (InvalidJsonException e) {
            System.err.println("Error: " + e.getMessage());
            return "{}";
        }
    }
}
