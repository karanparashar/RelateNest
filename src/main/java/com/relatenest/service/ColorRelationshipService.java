package com.relatenest.service;

import com.relatenest.dto.Repository.ColorRelationshipRepository;
import com.relatenest.dto.entity.ColorRelationship;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ColorRelationshipService {

    private final ColorRelationshipRepository repository;

    public ColorRelationshipService(ColorRelationshipRepository repository) {
        this.repository = repository;
    }

    public ColorRelationship saveOrUpdateCharacter(ColorRelationship character) {
        if (character.getId() != null) {
            // Ensure the entity exists before updating
            ColorRelationship existingCharacter = repository.findById(character.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Character not found with ID: " + character.getId()));
            existingCharacter.setName(character.getName());
            existingCharacter.setColor(character.getColor());
            existingCharacter.setParentId(character.getParentId());
            return repository.save(existingCharacter);
        } else {
            // Save as a new entity
            return repository.save(character);
        }
    }
    public List<ColorRelationship> getAllColorRelationship() {
        return repository.findAll();
    }

    public Optional<ColorRelationship> getColorRelationshipById(Long id) {
        return repository.findById(id);
    }

    public List<Map<String, Object>> getNestedStructure() {
        List<ColorRelationship> characters = repository.findAll();

        // Group entities by parentId
        Map<Long, List<ColorRelationship>> groupedByParentId = characters.stream()
                .collect(Collectors.groupingBy(ColorRelationship::getParentId));

        // Build the nested structure starting from root (parentId = 0)
        return groupedByParentId.getOrDefault(0L, new ArrayList<>()).stream()
                .map(root -> buildNestedMap(root, groupedByParentId))
                .collect(Collectors.toList());
    }

    private Map<String, Object> buildNestedMap(ColorRelationship character,
                                               Map<Long, List<ColorRelationship>> groupedByParentId) {
        Map<String, Object> map = new HashMap<>();
        map.put("Name", character.getName());
        List<Map<String, Object>> subClasses = groupedByParentId.getOrDefault(character.getId(), new ArrayList<>())
                .stream()
                .map(sub -> buildNestedMap(sub, groupedByParentId))
                .collect(Collectors.toList());
        if (!subClasses.isEmpty()) {
            map.put("Sub Classes", subClasses);
        }
        return map;
    }
}
