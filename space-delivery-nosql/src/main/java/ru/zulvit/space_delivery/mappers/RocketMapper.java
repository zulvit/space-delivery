package ru.zulvit.space_delivery.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zulvit.space_delivery.dto.request.RocketRequestDto;
import ru.zulvit.space_delivery.dto.response.RocketResponseDto;
import ru.zulvit.space_delivery.model.Rocket;

@Component
public class RocketMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public RocketMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RocketRequestDto convertToRequestDto(Rocket rocket) {
        return modelMapper.map(rocket, RocketRequestDto.class);
    }

    public RocketResponseDto convertToResponseDto(Rocket rocket) {
        return modelMapper.map(rocket, RocketResponseDto.class);
    }

    public Rocket convertToEntityFromRequestDto(RocketRequestDto rocketRequestDto) {
        return modelMapper.map(rocketRequestDto, Rocket.class);
    }

    public Rocket convertToEntityFromResponseDto(RocketResponseDto rocketResponseDto) {
        return modelMapper.map(rocketResponseDto, Rocket.class);
    }
}