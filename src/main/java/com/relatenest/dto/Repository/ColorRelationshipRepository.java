package com.relatenest.dto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.relatenest.dto.entity.ColorRelationship;


public interface ColorRelationshipRepository extends JpaRepository<ColorRelationship, Long> {
}