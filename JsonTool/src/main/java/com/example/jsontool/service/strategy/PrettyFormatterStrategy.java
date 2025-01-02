package com.example.jsontool.service.strategy;

import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.exceptions.InvalidJsonException;
import com.example.jsontool.service.templateMethod.AbstractFormatter;
import com.fasterxml.jackson.databind.JsonNode;

public class PrettyFormatterStrategy extends AbstractFormatter implements FormatterStrategy {

    @Override
    public String format(RawJsonDto rawJsonDto) {
        try {
            JsonNode rootNode = parseJson(rawJsonDto);
            StringBuilder builder = new StringBuilder();
            formatNodeRecursive(rootNode, 0, builder);
            return builder.toString().trim();
        } catch (Exception e) {
            throw new InvalidJsonException("Error during formatting", e);
        }
    }

    private void formatNodeRecursive(JsonNode node, int level, StringBuilder builder) {
        if (node.isObject()) {
            builder.append("{\n");
            node.fields().forEachRemaining(entry -> {
                appendIndent(builder, level + 1);
                builder.append("\"").append(entry.getKey()).append("\": ");
                formatNodeRecursive(entry.getValue(), level + 1, builder);
                builder.append(",\n");
            });
            removeTrailingComma(builder);
            builder.append("\n");
            appendIndent(builder, level);
            builder.append("}");
        } else if (node.isArray()) {
            builder.append("[\n");
            node.forEach(childNode -> {
                appendIndent(builder, level + 1);
                formatNodeRecursive(childNode, level + 1, builder);
                builder.append(",\n");
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
    }
}
