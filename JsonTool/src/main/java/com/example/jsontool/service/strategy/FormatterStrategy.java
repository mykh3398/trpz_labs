package com.example.jsontool.service.strategy;

import com.example.jsontool.dto.RawJsonDto;

public interface FormatterStrategy {
    String format(RawJsonDto rawJsonDto);
};

