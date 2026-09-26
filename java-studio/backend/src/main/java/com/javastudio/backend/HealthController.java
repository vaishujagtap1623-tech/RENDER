package com.javastudio.backend;

import java.util.Map;

import javax.sql.DataSource;
import java.sql.Connection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final DataSource dataSource;

    public HealthController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @GetMapping("/api/health")
    public Map<String, Object> health() {
        return Map.of(
                "status", "ok",
                "service", "java-studio-backend"
        );
    }

    @GetMapping("/api/health/db")
    public Map<String, Object> databaseHealth() {

        try (Connection connection = dataSource.getConnection()) {

            return Map.of(
                    "status", "ok",
                    "database", "connected",
                    "databaseName", connection.getCatalog()
            );

        } catch (Exception e) {

            return Map.of(
                    "status", "error",
                    "database", "not connected",
                    "message", e.getMessage()
            );
        }
    }
}
