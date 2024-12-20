//package com.example.jsontool.service.strategy.strategyImplementations;
//
//import com.example.jsontool.exceptions.InvalidJsonException;
//import com.example.jsontool.service.strategy.FormatterStrategy;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.util.Iterator;
//import java.util.Map;
//
//public class MarkdownFormatterStategy implements FormatterStrategy {
//
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    public String format(String json) throws InvalidJsonException {
//        try {
//            JsonNode jsonNode = objectMapper.readTree(json);
//
//            if (jsonNode.isArray()) {
//                return formatArray(jsonNode);
//            } else if (jsonNode.isObject()) {
//                return formatObject(jsonNode);
//            } else {
//                throw new InvalidJsonException("Unsupported JSON structure for Markdown Table");
//            }
//        } catch (Exception e) {
//            throw new InvalidJsonException("Invalid JSON format", e);
//        }
//    }
//
//    private String formatArray(JsonNode arrayNode) {
//        if (!arrayNode.isArray() || arrayNode.size() == 0) {
//            return "| Empty Table |\n|-------------|";
//        }
//
//        StringBuilder table = new StringBuilder();
//
//        // Build header from first object's fields
//        JsonNode firstRow = arrayNode.get(0);
//        if (firstRow.isObject()) {
//            appendTableHeader(table, firstRow);
//        } else {
//            throw new InvalidJsonException("Array elements are not objects");
//        }
//
//        // Append each row
//        for (JsonNode row : arrayNode) {
//            if (row.isObject()) {
//                appendTableRow(table, row);
//            } else {
//                throw new InvalidJsonException("Array elements are not objects");
//            }
//        }
//
//        return table.toString();
//    }
//
//    private String formatObject(JsonNode objectNode) {
//        if (!objectNode.isObject() || objectNode.size() == 0) {
//            return "| Key | Value |\n|-----|-------|\n| Empty | Table |";
//        }
//
//        StringBuilder table = new StringBuilder();
//        table.append("| Key | Value |\n");
//        table.append("|-----|-------|\n");
//
//        Iterator<Map.Entry<String, JsonNode>> fields = objectNode.fields();
//        while (fields.hasNext()) {
//            Map.Entry<String, JsonNode> field = fields.next();
//            table.append(String.format("| %s | %s |\n", field.getKey(), field.getValue().asText()));
//        }
//
//        return table.toString();
//    }
//
//    private void appendTableHeader(StringBuilder table, JsonNode row) {
//        table.append("|");
//        for (Iterator<String> it = row.fieldNames(); it.hasNext(); ) {
//            table.append(" ").append(it.next()).append(" |");
//        }
//        table.append("\n|");
//
//        for (int i = 0; i < row.size(); i++) {
//            table.append("-----|");
//        }
//        table.append("\n");
//    }
//
//    private void appendTableRow(StringBuilder table, JsonNode row) {
//        table.append("|");
//        for (Iterator<Map.Entry<String, JsonNode>> it = row.fields(); it.hasNext(); ) {
//            Map.Entry<String, JsonNode> field = it.next();
//            table.append(" ").append(field.getValue().asText()).append(" |");
//        }
//        table.append("\n");
//    }
//}
//
