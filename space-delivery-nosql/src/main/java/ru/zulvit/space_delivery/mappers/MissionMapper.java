package ru.zulvit.space_delivery.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.zulvit.space_delivery.dto.request.MissionRequestDto;
import ru.zulvit.space_delivery.dto.response.MissionResponseDto;
import ru.zulvit.space_delivery.model.Mission;

@Component
public class MissionMapper {
    private final ModelMapper modelMapper;

    public MissionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        modelMapper.typeMap(MissionRequestDto.class, Mission.class).addMappings(mapper -> {
            mapper.skip(Mission::setId);
        });
    }

    public MissionResponseDto convertToResponseDto(Mission mission) {
        return modelMapper.map(mission, MissionResponseDto.class);
    }

    public Mission convertToEntityFromRequestDto(MissionRequestDto missionRequestDto) {
        return modelMapper.map(missionRequestDto, Mission.class);
    }
}
