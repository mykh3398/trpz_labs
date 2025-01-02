package com.example.jsontool.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.dialect.PostgreSQLJsonPGObjectJsonbType;

import java.time.LocalDateTime;

@Data
@Builder
public class RawJsonDto {
    private Long rawId;
    private String rawData;
    private LocalDateTime rawCreatedOn;
}
