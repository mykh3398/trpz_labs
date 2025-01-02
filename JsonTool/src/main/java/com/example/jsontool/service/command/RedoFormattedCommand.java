package com.example.jsontool.service.command;

import com.example.jsontool.repository.HistoryEntry;
import com.example.jsontool.repository.HistoryManager;
import org.springframework.stereotype.Component;

@Component
public class RedoFormattedCommand implements Command {
    private final HistoryManager historyManager;

    public RedoFormattedCommand(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override
    public String execute() {
        historyManager.redoLastEntry();
        HistoryEntry currentEntry = historyManager.getCurrentEntry();
        return currentEntry != null ? currentEntry.getFormattedJson() : "{}";
    }

}
