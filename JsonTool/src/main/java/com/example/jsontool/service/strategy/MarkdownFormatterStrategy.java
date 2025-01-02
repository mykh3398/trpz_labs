package com.example.jsontool.service.strategy;

import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.exceptions.InvalidJsonException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MarkdownFormatterStrategy implements FormatterStrategy {

    private final ObjectMapper objectMapper;

    public MarkdownFormatterStrategy() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String format(RawJsonDto rawJsonDto) {
        try {
            JsonNode rootNode = objectMapper.readTree(rawJsonDto.getRawData());
            List<Row> rows = new ArrayList<>();
            buildRows("", rootNode, rows);

            return formatAsMarkdownTable(rows);
        } catch (Exception e) {
            throw new InvalidJsonException("Invalid JSON input", e);
        }
    }

    private void buildRows(String parentKey, JsonNode currentNode, List<Row> rows) {
        if (currentNode.isObject()) {
            for (Map.Entry<String, JsonNode> field : iterable(currentNode.fields())) {
                String key = parentKey.isEmpty() ? field.getKey() : parentKey + "." + field.getKey();
                buildRows(key, field.getValue(), rows);
            }
        } else if (currentNode.isArray()) {
            int index = 0;
            for (JsonNode arrayElement : currentNode) {
                String key = parentKey + "[" + index + "]";
                buildRows(key, arrayElement, rows);
                index++;
            }
        } else {
            rows.add(new Row(parentKey, currentNode.asText()));
        }
    }

    private String formatAsMarkdownTable(List<Row> rows) {
        int maxKeyLength = Math.max(
                rows.stream().mapToInt(row -> row.key.length()).max().orElse(0),
                "Key".length()
        );
        int maxValueLength = Math.max(
                rows.stream().mapToInt(row -> row.value.length()).max().orElse(0),
                "Value".length()
        );

        StringBuilder builder = new StringBuilder();

        String headerKey = String.format("%-" + maxKeyLength + "s", "Key");
        String headerValue = String.format("%-" + maxValueLength + "s", "Value");
        builder.append("| ").append(headerKey).append(" | ").append(headerValue).append(" |\n");

        builder.append("|-").append("-".repeat(maxKeyLength)).append("-|-")
                .append("-".repeat(maxValueLength)).append("-|\n");

        for (Row row : rows) {
            String formattedKey = String.format("%-" + maxKeyLength + "s", row.key);
            String formattedValue = String.format("%-" + maxValueLength + "s", row.value);
            builder.append("| ").append(formattedKey).append(" | ").append(formattedValue).append(" |\n");
        }

        return builder.toString();
    }


    private <T> Iterable<T> iterable(final Iterator<T> iterator) {
        return () -> iterator;
    }

    private static class Row {
        String key;
        String value;

        Row(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
