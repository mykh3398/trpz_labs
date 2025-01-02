package com.example.jsontool.service.templateMethod;

import com.example.jsontool.dto.RawJsonDto;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractFormatter {
    protected final ObjectMapper objectMapper = new ObjectMapper();

    protected JsonNode parseJson(RawJsonDto rawJsonDto) throws Exception {
        return objectMapper.readTree(rawJsonDto.getRawData());
    }

    protected void appendIndent(StringBuilder builder, int level) {
        builder.append("  ".repeat(level));
    }

    protected void removeTrailingComma(StringBuilder builder) {
        int length = builder.length();
        if (length > 2 && builder.substring(length - 2).equals(",\n")) {
            builder.delete(length - 2, length);
        }
    }
}
