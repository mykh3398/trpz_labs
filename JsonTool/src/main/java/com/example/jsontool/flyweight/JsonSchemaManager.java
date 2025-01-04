package com.example.jsontool.flyweight;

public class JsonSchemaManager {
    private final MetadataFactory metadataFactory = new MetadataFactory();

    public void processSchema() {
        SharedMetadata metadata1 = metadataFactory.getMetadata("string", "email", "An email address");
        SharedMetadata metadata2 = metadataFactory.getMetadata("integer", "none", "An integer value");

        JsonProperty property1 = new JsonProperty("email", "example@example.com", metadata1);
        JsonProperty property2 = new JsonProperty("age", 30, metadata2);

        System.out.println(property1.getName() + ": " + property1.getValue() + " (" + property1.getMetadata().getDescription() + ")");
        System.out.println(property2.getName() + ": " + property2.getValue() + " (" + property2.getMetadata().getDescription() + ")");
    }
}
