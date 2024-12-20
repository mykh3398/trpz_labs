package com.example.jsontool.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.dialect.PostgreSQLJsonPGObjectJsonbType;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Raw_Schema")
public class RawJson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jsonId;
    private String schemaName;
    private String schemaData;
    @CreationTimestamp
    private LocalDateTime createdOn;
}
