package com.example.jsontool.observer;

import java.util.ArrayList;
import java.util.List;

public class SchemaMetadataSubject {
    private final List<SchemaMetadataObserver> observers = new ArrayList<>();

    public void addObserver(SchemaMetadataObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(SchemaMetadataObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String key, String newValue) {
        for (SchemaMetadataObserver observer : observers) {
            observer.onMetadataUpdated(key, newValue);
        }
    }
}
