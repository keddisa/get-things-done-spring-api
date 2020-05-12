package com.andrewkeddis.getthingsdone.config;

import com.andrewkeddis.getthingsdone.dto.TaskDto;
import com.andrewkeddis.getthingsdone.models.Task;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        Converter<Task, TaskDto> taskTaskDtoConverter = new AbstractConverter<Task, TaskDto>() {
            @Override
            protected TaskDto convert(Task source) {
                return TaskDto.builder()
                        .id(source.getId())
                        .title(source.getTitle())
                        .description(source.getDescription())
                        .category(source.getCategory())
                        .priority(source.getPriority())
                        .status(source.getStatus())
                        .createdAt(source.getCreatedAt())
                        .deadline(source.getDeadline())
                        .pending(source.getPending())
                        .build();
            }
        };

        modelMapper.addConverter(taskTaskDtoConverter);

        return modelMapper;
    }
}
