package com.javastudio.backend;

import java.util.Map;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @PostMapping
    public Map<String, Object> create(@RequestBody Map<String, Object> body) {
        String name = String.valueOf(body.getOrDefault("name", "Untitled Project"));
        String type = String.valueOf(body.getOrDefault("type", "JAVA"));
        return Map.of("id", UUID.randomUUID().toString(), "name", name, "type", type, "message", "Project API scaffold ready");
    }
}
