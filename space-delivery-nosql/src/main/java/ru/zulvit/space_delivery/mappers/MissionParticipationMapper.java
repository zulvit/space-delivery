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
    private final AstronautService astronautService;

    private final MissionService missionService;

    private ModelMapper modelMapper;

    @Autowired
    public MissionParticipationMapper(AstronautService astronautService, MissionService missionService) {
        this.astronautService = astronautService;
        this.missionService = missionService;
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }

    public MissionParticipation requestDtoToEntity(MissionParticipationRequestDto dto) {
        MissionParticipation entity = modelMapper.map(dto, MissionParticipation.class);

        entity.setAstronautId(astronautService.getAstronautById(dto.getAstronautId()).getId());
        entity.setMissionId(missionService.getMissionById(dto.getMissionId()).getId());

        return entity;
    }

    public MissionParticipationResponseDto entityToResponseDto(MissionParticipation entity) {
        MissionParticipationResponseDto dto = modelMapper.map(entity, MissionParticipationResponseDto.class);

        dto.setAstronautId(entity.getAstronautId());
        dto.setMissionId(entity.getMissionId());

        return dto;
    }
}