package com.example.jsontool.repository;

import org.springframework.stereotype.Component;

@Component
public class HistoryManager {
    private final InMemoryHistoryRepository repository;

    public HistoryManager(InMemoryHistoryRepository repository) {
        this.repository = repository;
    }

    public void addEntry(String formattedJson, String formatType) {
        repository.save(new HistoryEntry(formattedJson, formatType));
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
