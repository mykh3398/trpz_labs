package com.example.jsontool.service.strategy;

import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.exceptions.InvalidJsonException;
import com.example.jsontool.service.templateMethod.AbstractFormatter;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Iterator;
import java.util.Map;

public class FlatFormatterStrategy extends AbstractFormatter implements FormatterStrategy {

    @Override
    public String format(RawJsonDto rawJsonDto) {
        try {
            JsonNode rootNode = parseJson(rawJsonDto);
            StringBuilder builder = new StringBuilder();
            formatNodeRecursive(rootNode, "", builder);
            return builder.toString().trim();
        } catch (Exception e) {
            throw new InvalidJsonException("Error during formatting", e);
        }
    }

    private void formatNodeRecursive(JsonNode node, String currentPath, StringBuilder builder) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                String newPath = currentPath.isEmpty() ? field.getKey() : currentPath + "." + field.getKey();
                formatNodeRecursive(field.getValue(), newPath, builder);
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                String newPath = currentPath + "[" + i + "]";
                formatNodeRecursive(node.get(i), newPath, builder);
            }
        } else {
            builder.append(currentPath)
                    .append(": ")
                    .append(node.isTextual() ? "\"" + node.asText() + "\"" : node.toString())
                    .append("\n");
        }
    }
}
