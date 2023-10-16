package ru.zulvit.space_delivery.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zulvit.space_delivery.dto.request.AstronautRequestDto;
import ru.zulvit.space_delivery.dto.response.AstronautResponseDto;
import ru.zulvit.space_delivery.model.Astronaut;

@Component
public class AstronautMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public AstronautMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AstronautRequestDto convertToRequestDto(Astronaut astronaut) {
        return modelMapper.map(astronaut, AstronautRequestDto.class);
    }

    public AstronautResponseDto convertToResponseDto(Astronaut astronaut) {
        return modelMapper.map(astronaut, AstronautResponseDto.class);
    }

    public Astronaut convertToEntityFromRequestDto(AstronautRequestDto astronautRequestDto) {
        return modelMapper.map(astronautRequestDto, Astronaut.class);
    }

    public Astronaut convertToEntityFromResponseDto(AstronautResponseDto astronautResponseDto) {
        return modelMapper.map(astronautResponseDto, Astronaut.class);
    }
}