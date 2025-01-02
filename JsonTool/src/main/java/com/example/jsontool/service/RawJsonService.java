package com.example.jsontool.service;

import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.models.RawJson;

import java.util.List;

public interface RawJsonService {
    String formatJson(RawJsonDto json, String formatType);
}
