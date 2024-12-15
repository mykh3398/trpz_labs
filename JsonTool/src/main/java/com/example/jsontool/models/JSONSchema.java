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
public class JSONSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jsonId;
    private PostgreSQLJsonPGObjectJsonbType schemaData;
    @CreationTimestamp
    private LocalDateTime createdOn;
}
