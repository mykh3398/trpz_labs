package com.example.jsontool.command;

import com.example.jsontool.command.Command;
import com.example.jsontool.command.commandHistory.HistoryEntry;
import com.example.jsontool.command.commandHistory.HistoryManager;
import org.springframework.stereotype.Component;

@Component
public class RedoCommand implements Command {
    private final HistoryManager historyManager;

    public RedoCommand(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override
    public String execute() {
        historyManager.redoLastEntry();
        HistoryEntry currentEntry = historyManager.getCurrentEntry();
        return currentEntry != null ? currentEntry.getFormattedJson() : "{}";
    }

}
