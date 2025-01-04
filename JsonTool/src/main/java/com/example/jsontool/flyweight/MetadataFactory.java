package com.example.jsontool.flyweight;

import java.util.HashMap;
import java.util.Map;

public class  MetadataFactory {
    private final Map<String, SharedMetadata> metadataPool = new HashMap<>();

    public SharedMetadata getMetadata(String type, String format, String description) {
        String key = type + ":" + format + ":" + description;
        if (!metadataPool.containsKey(key)) {
            metadataPool.put(key, new SharedMetadata(type, format, description));
        }
        return metadataPool.get(key);
    }
}
