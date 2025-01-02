package com.example.jsontool.service;

import com.example.jsontool.repository.HistoryManager;
import com.example.jsontool.exceptions.InvalidJsonException;
import com.example.jsontool.service.command.RedoFormattedCommand;
import com.example.jsontool.service.command.UndoFormattedCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormattedJsonServiceImplementation implements FormattedJsonService {
    private final HistoryManager historyManager;
    @Autowired
    public FormattedJsonServiceImplementation(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }
    @Override
    public String redoFormattedJson() {
        try {
            RedoFormattedCommand command = new RedoFormattedCommand(historyManager);
            return command.execute();
        } catch (InvalidJsonException e) {
            System.err.println("Error: " + e.getMessage());
            return "{}";
        }
    }

    @Override
    public String undoFormattedJson() {
        try {
            UndoFormattedCommand command = new UndoFormattedCommand(historyManager);
            return command.execute();
        } catch (InvalidJsonException e) {
            System.err.println("Error: " + e.getMessage());
            return "{}";
        }
    }

}
