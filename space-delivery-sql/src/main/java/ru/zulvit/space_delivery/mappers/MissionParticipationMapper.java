package ru.zulvit.space_delivery.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zulvit.space_delivery.dto.request.MissionParticipationRequestDto;
import ru.zulvit.space_delivery.dto.response.MissionParticipationResponseDto;
import ru.zulvit.space_delivery.model.MissionParticipation;
import ru.zulvit.space_delivery.service.AstronautService;
import ru.zulvit.space_delivery.service.MissionService;

@Component
public class MissionParticipationMapper {

    @Autowired
    private AstronautService astronautService;

    @Autowired
    private MissionService missionService;

    private ModelMapper modelMapper;

    public MissionParticipationMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public MissionParticipation requestDtoToEntity(MissionParticipationRequestDto dto) {
        MissionParticipation entity = modelMapper.map(dto, MissionParticipation.class);

        entity.setAstronaut(astronautService.getAstronautById(dto.getAstronautId()));
        entity.setMission(missionService.getMissionById(dto.getMissionId()));

        return entity;
    }

    public MissionParticipationResponseDto entityToResponseDto(MissionParticipation entity) {
        MissionParticipationResponseDto dto = modelMapper.map(entity, MissionParticipationResponseDto.class);

        dto.setAstronautId(entity.getAstronaut().getId());
        dto.setMissionId(entity.getMission().getId());

        return dto;
    }
}