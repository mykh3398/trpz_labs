package com.example.jsontool.flyweight;

public class SharedMetadata implements Metadata {
    private final String type;
    private final String format;
    private final String description;

    public SharedMetadata(String type, String format, String description) {
        this.type = type;
        this.format = format;
        this.description = description;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
