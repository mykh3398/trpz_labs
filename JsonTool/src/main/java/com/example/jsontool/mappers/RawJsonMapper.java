package com.example.jsontool.mappers;

import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.models.RawJson;

public class RawJsonMapper {
    public static RawJsonDto mapToRawJsonDto(RawJson rawJson){
        RawJsonDto rawJsonDto = RawJsonDto.builder()
                .jsonId(rawJson.getJsonId())
                .schemaData(rawJson.getSchemaData())
                .schemaName(rawJson.getSchemaName())
                .createdOn(rawJson.getCreatedOn())
                .build();
        return rawJsonDto;
    }

    public static RawJson mapToRawJson(RawJsonDto rawJson) {
        RawJson rawJsonDto = RawJson.builder()
                .jsonId(rawJson.getJsonId())
                .schemaData(rawJson.getSchemaData())
                .schemaName(rawJson.getSchemaName())
                .createdOn(rawJson.getCreatedOn())
                .build();
        return rawJsonDto;
    }

}
