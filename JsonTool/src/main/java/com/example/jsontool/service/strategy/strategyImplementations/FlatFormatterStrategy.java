package com.example.jsontool.service.strategy.strategyImplementations;

import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.exceptions.InvalidJsonException;
import com.example.jsontool.service.strategy.FormatterStrategy;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.Map;

public class FlatFormatterStrategy implements FormatterStrategy {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String format(RawJsonDto rawJsonDto) {
        try {
            JsonNode rootNode = objectMapper.readTree(rawJsonDto.getSchemaData());
            StringBuilder builder = new StringBuilder();
            formatNode(rootNode, "", builder);
            return builder.toString().trim();
        } catch (Exception e) {
            throw new InvalidJsonException("Invalid JSON input", e);
        }
    }

    private void formatNode(JsonNode node, String currentPath, StringBuilder builder) {
        if (node.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                String newPath = currentPath.isEmpty() ? field.getKey() : currentPath + "." + field.getKey();
                formatNode(field.getValue(), newPath, builder);
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                String newPath = currentPath + "[" + i + "]";
                formatNode(node.get(i), newPath, builder);
            }
        } else {
            builder.append(currentPath)
                    .append(": ")
                    .append(node.isTextual() ? "\"" + node.asText() + "\"" : node.toString())
                    .append("\n");
        }
    }
}
