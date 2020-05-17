package ru.itis.apideadathomejwt.service;

import ru.itis.apideadathomejwt.dto.HousesDto;

import java.util.List;

public interface HousesService {
    List<HousesDto> getHouses();
    HousesDto getConcreteHouse(Long houseId);

    List<HousesDto> search(String name);

}
