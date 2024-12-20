package com.example.jsontool.service.strategy;

import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.exceptions.InvalidJsonException;
import com.example.jsontool.service.strategy.FormatterStrategy;

public class JsonFormatterContext {
    private FormatterStrategy formatterStrategy;

    public void setFormatterStrategy(FormatterStrategy formatterStrategy) {
        this.formatterStrategy = formatterStrategy;
    }

    public String format(RawJsonDto jsonInput) {
        if (formatterStrategy == null) {
            throw new IllegalStateException("No formatter strategy set");
        }
        try {
            return formatterStrategy.format(jsonInput);
        } catch (InvalidJsonException e) {
            System.err.println("Error formatting JSON: " + e.getMessage());
            throw e;
        }
    }
}

