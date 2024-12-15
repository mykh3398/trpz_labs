package com.example.jsontool.repository;

import com.example.jsontool.models.JSONSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<JSONSchema, Long> {
}
