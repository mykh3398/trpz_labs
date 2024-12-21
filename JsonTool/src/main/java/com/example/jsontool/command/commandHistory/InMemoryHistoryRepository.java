package com.example.jsontool.command.commandHistory;

import com.example.jsontool.command.commandHistory.HistoryEntry;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
public class InMemoryHistoryRepository {
    private final Stack<HistoryEntry> undoStack = new Stack<>();
    private final Stack<HistoryEntry> redoStack = new Stack<>();

    public void save(HistoryEntry entry) {
        undoStack.push(entry);
        redoStack.clear();
    }
    public void removeLastEntry() {
        if (!undoStack.isEmpty()) {
            redoStack.push(undoStack.pop());
        }
    }

    public void redoLastEntry() {
        if (!redoStack.isEmpty()) {
            undoStack.push(redoStack.pop());
        }
    }
    public HistoryEntry getCurrentEntry() {
        return undoStack.isEmpty() ? null : undoStack.peek();
    }
}
