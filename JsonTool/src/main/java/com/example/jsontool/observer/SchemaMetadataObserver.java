package com.example.jsontool.observer;

public interface SchemaMetadataObserver {
    void onMetadataUpdated(String key, String newValue);
}
