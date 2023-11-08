package ru.zulvit.space_delivery.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.zulvit.space_delivery.dto.request.MissionParticipationRequestDto;
import ru.zulvit.space_delivery.dto.response.MissionParticipationResponseDto;
import ru.zulvit.space_delivery.model.MissionParticipation;

@Component
public class MissionParticipationMapper {

    private ModelMapper modelMapper;

    public MissionParticipationMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public MissionParticipation requestDtoToEntity(MissionParticipationRequestDto dto) {
        return modelMapper.map(dto, MissionParticipation.class);
    }

    public MissionParticipationResponseDto entityToResponseDto(MissionParticipation entity) {
        return modelMapper.map(entity, MissionParticipationResponseDto.class);
    }
}
