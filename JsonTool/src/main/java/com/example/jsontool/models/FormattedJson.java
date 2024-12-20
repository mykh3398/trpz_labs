package com.example.jsontool.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.dialect.PostgreSQLJsonPGObjectJsonbType;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormattedJson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formattedJsonId;
    private PostgreSQLJsonPGObjectJsonbType formattedSchemaData;
    private int is_active;
    @CreationTimestamp
    private LocalDateTime createdOn;

    private Long FK_JsonId;
    private Long FK_formatterId;
}
