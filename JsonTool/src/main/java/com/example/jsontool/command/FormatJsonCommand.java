package com.example.jsontool.command;

import com.example.jsontool.command.commandHistory.HistoryEntry;
import com.example.jsontool.command.commandHistory.HistoryManager;
import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.service.strategy.JsonFormatterContext;
import com.example.jsontool.service.strategy.strategyImplementations.FlatFormatterStrategy;
import com.example.jsontool.service.strategy.strategyImplementations.PrettyFormatterStrategy;

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
            default:
                throw new IllegalArgumentException("Unknown format type: " + formatType);
        }
        result = formatterContext.format(rawJsonDto);
        historyManager.addEntry(rawJsonDto.getSchemaData(), result, formatType);
        return result;
    }

}
