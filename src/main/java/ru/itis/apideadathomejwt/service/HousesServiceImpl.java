package ru.itis.apideadathomejwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.apideadathomejwt.dto.HousesDto;
import ru.itis.apideadathomejwt.repository.HousesRepository;

import java.util.List;

import static ru.itis.apideadathomejwt.dto.HousesDto.from;

@Service
public class HousesServiceImpl implements HousesService {


    @Autowired
    private HousesRepository housesRepository;

    @Override
    public List<HousesDto> getHouses() {
        return from(housesRepository.findAll());
    }

    @Override
    public HousesDto getConcreteHouse(Long houseId) {
        return from(housesRepository.getOne(houseId));
    }

    @Override
    public List<HousesDto> search(String name) {
        return from(housesRepository.search(name));
    }

}
