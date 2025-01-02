package com.example.jsontool.repository;

public class HistoryEntry {
    private final String formattedJson;
    private final String formatType;

    public HistoryEntry(String formattedJson, String formatType) {
        this.formattedJson = formattedJson;
        this.formatType = formatType;
    }

    public String getFormattedJson() {
        return formattedJson;
    }
}

