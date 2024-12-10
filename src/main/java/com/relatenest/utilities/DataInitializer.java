package com.relatenest.utilities;

import com.relatenest.dto.Repository.ColorRelationshipRepository;
import com.relatenest.dto.entity.ColorRelationship;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initializeDatabase(ColorRelationshipRepository repository) {
        return args -> {
            // Save parent records
            ColorRelationship warrior = repository.save(new ColorRelationship(null, "Warrior", "red", 0L));
            ColorRelationship wizard = repository.save(new ColorRelationship(null, "Wizard", "green", 0L));
            ColorRelationship priest = repository.save(new ColorRelationship(null, "Priest", "white", 0L));
            ColorRelationship rogue = repository.save(new ColorRelationship(null, "Rogue", "yellow", 0L));

            // Save child records with parent references
            repository.save(new ColorRelationship(null, "Fighter", "blue", warrior.getId()));
            repository.save(new ColorRelationship(null, "Paladin", "lightblue", warrior.getId()));
            repository.save(new ColorRelationship(null, "Ranger", "lightgreen", warrior.getId()));

            repository.save(new ColorRelationship(null, "Mage", "grey", wizard.getId()));
            repository.save(new ColorRelationship(null, "Specialist wizard", "lightgrey", wizard.getId()));

            repository.save(new ColorRelationship(null, "Cleric", "red", priest.getId()));
            repository.save(new ColorRelationship(null, "Druid", "green", priest.getId()));
            repository.save(new ColorRelationship(null, "Priest of specific mythos", "white", priest.getId()));

            repository.save(new ColorRelationship(null, "Thief", "yellow", rogue.getId()));
            repository.save(new ColorRelationship(null, "Bard", "blue", rogue.getId()));
            repository.save(new ColorRelationship(null, "Assassin", "lightblue", 13L)); // Add thief as parent for Assassin

            System.out.println("Database initialized with sample data!");
        };
    }

}
