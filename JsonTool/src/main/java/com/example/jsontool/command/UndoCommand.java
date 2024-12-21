package com.example.jsontool.command;

import com.example.jsontool.command.Command;
import com.example.jsontool.command.commandHistory.HistoryEntry;
import com.example.jsontool.command.commandHistory.HistoryManager;
import org.springframework.stereotype.Component;

@Component
public class UndoCommand implements Command {
    private final HistoryManager historyManager;

    public UndoCommand(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override
    public String execute() {
        historyManager.undoLastEntry();
        HistoryEntry currentEntry = historyManager.getCurrentEntry();
        return currentEntry != null ? currentEntry.getFormattedJson() : "{}";
    }

}
