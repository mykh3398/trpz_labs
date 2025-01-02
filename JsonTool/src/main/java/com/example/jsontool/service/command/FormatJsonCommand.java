package com.example.jsontool.service.command;

import com.example.jsontool.repository.HistoryManager;
import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.service.strategy.FlatFormatterStrategy;
import com.example.jsontool.service.strategy.JsonFormatterContext;
import com.example.jsontool.service.strategy.MarkdownFormatterStrategy;
import com.example.jsontool.service.strategy.PrettyFormatterStrategy;

public class FormatJsonCommand implements Command {
    private final RawJsonDto rawJsonDto;
    private final String formatType;
    private final JsonFormatterContext formatterContext;
    private final HistoryManager historyManager;
    private String result;

    public FormatJsonCommand(RawJsonDto rawJsonDto, String formatType, JsonFormatterContext formatterContext, HistoryManager historyManager) {
        this.rawJsonDto = rawJsonDto;
        this.formatType = formatType;
        this.formatterContext = formatterContext;
        this.historyManager = historyManager;
    }

    @Override
    public String execute() {
        switch (formatType.toLowerCase()) {
            case "flat":
                formatterContext.setFormatterStrategy(new FlatFormatterStrategy());
                break;
            case "pretty":
                formatterContext.setFormatterStrategy(new PrettyFormatterStrategy());
                break;
            case "markdown":
                formatterContext.setFormatterStrategy(new MarkdownFormatterStrategy());
                break;
            default:
                throw new IllegalArgumentException("Unknown format type: " + formatType);
        }
        result = formatterContext.format(rawJsonDto);
        historyManager.addEntry(result, formatType);
        return result;
    }
}
