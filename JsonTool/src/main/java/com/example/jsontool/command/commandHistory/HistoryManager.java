package com.example.jsontool.command.commandHistory;

import org.springframework.stereotype.Component;

@Component
public class HistoryManager {
    private final InMemoryHistoryRepository repository;

    public HistoryManager(InMemoryHistoryRepository repository) {
        this.repository = repository;
    }

    public void addEntry(String rawJson, String formattedJson, String formatType) {
        repository.save(new HistoryEntry(rawJson, formattedJson, formatType));
    }

    public void undoLastEntry() {
        repository.removeLastEntry();
    }

    public void redoLastEntry() {
        repository.redoLastEntry();
    }

    public HistoryEntry getCurrentEntry() {
        return repository.getCurrentEntry();
    }
}
