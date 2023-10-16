package ru.zulvit.space_delivery.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zulvit.space_delivery.dto.request.MissionRequestDto;
import ru.zulvit.space_delivery.dto.response.MissionResponseDto;
import ru.zulvit.space_delivery.model.Mission;
import ru.zulvit.space_delivery.service.CargoService;
import ru.zulvit.space_delivery.service.RocketService;

@Component
public class MissionMapper {
    private final ModelMapper modelMapper;
    private final RocketService rocketService;
    private final CargoService cargoService;

    @Autowired
    public MissionMapper(ModelMapper modelMapper, RocketService rocketService, CargoService cargoService) {
        this.modelMapper = modelMapper;
        this.rocketService = rocketService;
        this.cargoService = cargoService;

        modelMapper.addMappings(new PropertyMap<MissionRequestDto, Mission>() {
            protected void configure() {
                skip(destination.getId());
            }
        });
    }

    public MissionRequestDto convertToRequestDto(Mission mission) {
        return modelMapper.map(mission, MissionRequestDto.class);
    }

    public MissionResponseDto convertToResponseDto(Mission mission) {
        return modelMapper.map(mission, MissionResponseDto.class);
    }

    public Mission convertToEntityFromRequestDto(MissionRequestDto missionRequestDto) {
        Mission mission = modelMapper.map(missionRequestDto, Mission.class);
        mission.setRocket(rocketService.getRocketById(missionRequestDto.getRocketId()));
        mission.setCargo(cargoService.getCargoById(missionRequestDto.getCargoId()));

        return mission;
    }

    public Mission convertToEntityFromResponseDto(MissionResponseDto missionResponseDto) {
        return modelMapper.map(missionResponseDto, Mission.class);
    }
}