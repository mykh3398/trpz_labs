package com.example.jsontool.repository;

import com.example.jsontool.models.RawJson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<RawJson, Long> {
}
