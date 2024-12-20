package com.example.jsontool.service;

import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.models.RawJson;

import java.util.List;

public interface RawJsonService {
    RawJsonDto getRawJsonById(Long rawJsonId);
    RawJsonDto saveRawJson(RawJsonDto rawJson);
    List<RawJsonDto> getAllRawJsons();
    RawJsonDto updateRawJson(Long rawJsonId, RawJsonDto updatedRawJson);
    void deleteRawJson(Long rawJsonId);
    String formatJson(RawJsonDto json, String formatType);
}
