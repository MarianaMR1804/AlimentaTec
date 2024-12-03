package com.example.alimentaTec.configuration;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.alimentaTec.dto.JournalDTO;
import com.example.alimentaTec.model.Journal;
import com.example.alimentaTec.model.Goal;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<JournalDTO, Journal>() {
            @Override
            protected void configure() {
                // Mapea idGoal a un objeto Goal
                using(ctx -> {
                    Goal goal = new Goal();
                    goal.setIdGoal((Integer) ctx.getSource());
                    return goal;
                }).map(source.getIdGoal(), destination.getGoal());
            }
        });
        return modelMapper;
    }
}