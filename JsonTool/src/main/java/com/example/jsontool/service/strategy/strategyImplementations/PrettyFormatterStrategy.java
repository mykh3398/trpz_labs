package com.example.jsontool.service.strategy.strategyImplementations;

import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.exceptions.InvalidJsonException;
import com.example.jsontool.service.strategy.FormatterStrategy;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PrettyFormatterStrategy implements FormatterStrategy {

    private final ObjectMapper objectMapper;

    public PrettyFormatterStrategy() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public String format(RawJsonDto rawJsonDto) {
        try {
            JsonNode rootNode = objectMapper.readTree(rawJsonDto.getSchemaData());
            return formatNode(rootNode, 0);
        } catch (Exception e) {
            throw new InvalidJsonException("Invalid JSON input", e);
        }
    }

    private String formatNode(JsonNode node, int level) {
        StringBuilder builder = new StringBuilder();

        if (node.isObject()) {
            builder.append("{\n");
            node.fields().forEachRemaining(entry -> {
                appendIndent(builder, level + 1);
                builder.append("\"").append(entry.getKey()).append("\": ");
                builder.append(formatNode(entry.getValue(), level + 1)).append(",\n");
            });
            removeTrailingComma(builder);
            builder.append("\n");
            appendIndent(builder, level);
            builder.append("}");
        } else if (node.isArray()) {
            builder.append("[\n");
            node.forEach(childNode -> {
                appendIndent(builder, level + 1);
                builder.append(formatNode(childNode, level + 1)).append(",\n");
            });
            removeTrailingComma(builder);
            builder.append("\n");
            appendIndent(builder, level);
            builder.append("]");
        } else {
            if (node.isTextual()) {
                builder.append("\"").append(node.asText()).append("\"");
            } else {
                builder.append(node.toString());
            }
        }

        return builder.toString();
    }


    private void appendIndent(StringBuilder builder, int level) {
        builder.append("  ".repeat(level));
    }

    private void removeTrailingComma(StringBuilder builder) {
        int length = builder.length();
        if (length > 2 && builder.substring(length - 2).equals(",\n")) {
            builder.delete(length - 2, length);
        }
    }
}
