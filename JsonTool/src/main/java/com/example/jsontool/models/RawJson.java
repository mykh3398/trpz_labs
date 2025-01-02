package com.example.jsontool.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.dialect.PostgreSQLJsonPGObjectJsonbType;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RawJson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rawId;


    private String rawData;


    private LocalDateTime rawCreatedOn;
}

