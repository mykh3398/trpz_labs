package com.example.jsontool.controllers;
import com.example.jsontool.dto.RawJsonDto;
import com.example.jsontool.service.RawJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rawJson")

public class RawJsonController {
    private RawJsonService rawJsonService;
    @Autowired
    public RawJsonController(RawJsonService rawJsonService) {
        this.rawJsonService = rawJsonService;
    }
    @PostMapping("/format/{type}")
    public ResponseEntity<String> formatJson(@RequestBody RawJsonDto rawJsonDto, @PathVariable("type") String type) {
        try {
            String formattedJson = rawJsonService.formatJson(rawJsonDto, type);
            return ResponseEntity.ok(formattedJson);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Invalid JSON input: " + e.getMessage());
        }
    }

    @PostMapping("/undo")
    public ResponseEntity<String> undoLastChange() {
        String json = rawJsonService.undoLastFormat();
        return ResponseEntity.ok(json);
    }

    @PostMapping("/redo")
    public ResponseEntity<String> redoLastChange() {
        String json = rawJsonService.redoLastFormat();
        return ResponseEntity.ok(json);
    }
    @PostMapping("/save")
    public ResponseEntity<RawJsonDto> createRawJson(@RequestBody RawJsonDto rawJsonDto) {
        RawJsonDto savedRawJson = rawJsonService.saveRawJson(rawJsonDto);
        return new ResponseEntity<>(savedRawJson, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RawJsonDto> getRawJsonById(@PathVariable("id") Long rawJsonId){
        RawJsonDto rawJsons = rawJsonService.getRawJsonById(rawJsonId);
        return ResponseEntity.ok(rawJsons);
    }

    @GetMapping("/all")
    public ResponseEntity<List<RawJsonDto>> getAllRawJsons(){
        List<RawJsonDto> rawJsons = rawJsonService.getAllRawJsons();
        return ResponseEntity.ok(rawJsons);
    }
    @PutMapping("{id}")
    public ResponseEntity<RawJsonDto> updateRawJson(@PathVariable("id") Long rawJsonId,
                                                      @RequestBody RawJsonDto updatedRawJsonId){
        RawJsonDto rawJsonDto = rawJsonService.updateRawJson(rawJsonId, updatedRawJsonId);
        return ResponseEntity.ok(rawJsonDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRawJson(@PathVariable("id") Long rawJsonId){
        rawJsonService.deleteRawJson(rawJsonId);
        return ResponseEntity.ok("Employee deleted successfully!.");
    }

}
