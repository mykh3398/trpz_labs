package com.example.jsontool.service.implementation;

import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.exceptions.InvalidJsonException;
import com.example.jsontool.exceptions.ResourceNotFoundException;
import com.example.jsontool.mappers.RawJsonMapper;
import com.example.jsontool.models.RawJson;
import com.example.jsontool.repository.RawJsonRepository;
import com.example.jsontool.service.RawJsonService;
import com.example.jsontool.service.strategy.JsonFormatterContext;
import com.example.jsontool.service.strategy.strategyImplementations.FlatFormatterStrategy;
import com.example.jsontool.service.strategy.strategyImplementations.PrettyFormatterStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.jsontool.mappers.RawJsonMapper.mapToRawJson;
import static com.example.jsontool.mappers.RawJsonMapper.mapToRawJsonDto;
@Service
public class RawJsonServiceImplementation implements RawJsonService {
    private RawJsonRepository rawJsonRepository;
    private final JsonFormatterContext formatterContext = new JsonFormatterContext();
    @Autowired
    public RawJsonServiceImplementation(RawJsonRepository rawJsonRepository) {
        this.rawJsonRepository = rawJsonRepository;
    }
    @Override
    public String formatJson(RawJsonDto rawJsonDto, String formatType) {
        try {
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
            return formatterContext.format(rawJsonDto);
        } catch (InvalidJsonException e) {
            System.err.println("Error: " + e.getMessage());
            return "{}";
        }
    }
    @Override
    public RawJsonDto saveRawJson(RawJsonDto rawJsonDto) {
        RawJson rawJson = RawJsonMapper.mapToRawJson(rawJsonDto);
        RawJson savedRawJson = rawJsonRepository.save(rawJson);
        return mapToRawJsonDto(savedRawJson);
    }
    @Override
    public RawJsonDto getRawJsonById(Long rawJsonId) {
        RawJson rawJson = rawJsonRepository.findById(rawJsonId)
                .orElseThrow(() -> new ResourceNotFoundException("Json does not exist with given id: " + rawJsonId));
        return mapToRawJsonDto(rawJson);
    }

    @Override
    public List<RawJsonDto> getAllRawJsons() {
        List<RawJson> rawJsons = rawJsonRepository.findAll();
        return rawJsons.stream().map((rawJson) -> mapToRawJsonDto(rawJson)).collect(Collectors.toList());
    }

    @Override
    public RawJsonDto updateRawJson(Long rawJsonId, RawJsonDto updatedRawJson) {
        RawJson rawJson = rawJsonRepository.findById(rawJsonId).orElseThrow(
                () -> new ResourceNotFoundException("Json does not exists with given id: " + rawJsonId)
        );

        rawJson.setSchemaData(updatedRawJson.getSchemaData());
        rawJson.setSchemaName(updatedRawJson.getSchemaName());

        RawJson updatedRawJsonObj = rawJsonRepository.save(rawJson);
        return mapToRawJsonDto(updatedRawJsonObj);
    }

    @Override
    public void deleteRawJson(Long rawJsonId) {
        RawJson rawJson = rawJsonRepository.findById(rawJsonId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + rawJsonId)
        );

        rawJsonRepository.deleteById(rawJsonId);
    }

}
