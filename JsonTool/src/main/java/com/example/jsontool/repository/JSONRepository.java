package com.example.jsontool.repository;

import com.example.jsontool.models.JSONSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JSONRepository extends JpaRepository<JSONSchema, Long> {

}
