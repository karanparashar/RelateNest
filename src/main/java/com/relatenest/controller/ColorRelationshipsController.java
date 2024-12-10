package com.relatenest.controller;

import com.relatenest.dto.entity.ColorRelationship;
import com.relatenest.service.ColorRelationshipService;
import com.relatenest.utilities.LogMethodParam;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/characters")
public class ColorRelationshipsController {

    private final ColorRelationshipService service;

    public ColorRelationshipsController(ColorRelationshipService service) {
        this.service = service;
    }

    @PostMapping
    @LogMethodParam
    @Transactional
    public ColorRelationship createColorRelationships(@RequestBody ColorRelationship colorRelationship) {
        return service.saveOrUpdateCharacter(colorRelationship);
    }

    @GetMapping
    @LogMethodParam
    public List<ColorRelationship> getAllColorRelationships() {
        return service.getAllColorRelationship();
    }

    @GetMapping("/{id}")
    @LogMethodParam
    public ColorRelationship getColorRelationshipsById(@PathVariable Long id) {
        return service.getColorRelationshipById(id).orElse(null);
    }

    @GetMapping("/nested")
    @LogMethodParam
    public List<Map<String, Object>> getNestedStructure() {
        return service.getNestedStructure();
    }
}
