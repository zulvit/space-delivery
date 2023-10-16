package ru.zulvit.space_delivery.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.zulvit.space_delivery.dto.request.CargoRequestDto;
import ru.zulvit.space_delivery.dto.response.CargoResponseDto;
import ru.zulvit.space_delivery.model.Cargo;

@Component
public class CargoMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public CargoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CargoRequestDto convertToRequestDto(Cargo cargo) {
        return modelMapper.map(cargo, CargoRequestDto.class);
    }

    public CargoResponseDto convertToResponseDto(Cargo cargo) {
        return modelMapper.map(cargo, CargoResponseDto.class);
    }

    public Cargo convertToEntityFromRequestDto(CargoRequestDto cargoRequestDto) {
        return modelMapper.map(cargoRequestDto, Cargo.class);
    }

    public Cargo convertToEntityFromResponseDto(CargoResponseDto cargoResponseDto) {
        return modelMapper.map(cargoResponseDto, Cargo.class);
    }
}