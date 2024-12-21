package com.example.jsontool.command.commandHistory;

public class HistoryEntry {
    private final String rawJson;
    private final String formattedJson;
    private final String formatType;

    public HistoryEntry(String rawJson, String formattedJson, String formatType) {
        this.rawJson = rawJson;
        this.formattedJson = formattedJson;
        this.formatType = formatType;
    }

    public String getFormattedJson() {
        return formattedJson;
    }

}

