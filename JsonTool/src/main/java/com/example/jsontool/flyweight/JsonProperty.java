package com.example.jsontool.flyweight;

public class JsonProperty {
    private final String name;
    private final Object value;
    private final SharedMetadata metadata;

    public JsonProperty(String name, Object value, SharedMetadata metadata) {
        this.name = name;
        this.value = value;
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public SharedMetadata getMetadata() {
        return metadata;
    }
}
