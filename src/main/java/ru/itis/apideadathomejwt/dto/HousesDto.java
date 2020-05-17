package ru.itis.apideadathomejwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.apideadathomejwt.models.House;
import ru.itis.apideadathomejwt.models.HouseClass;
import ru.itis.apideadathomejwt.models.Location;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HousesDto {
    private Long id;
    private String name;
    private UserDto creator;
    private LocalDateTime createdAt;
    private HouseClass houseClass;
    private String description;
    private Location location;

    public static HousesDto from(House house) {
        return HousesDto.builder()
                .id(house.getId())
                .name(house.getName())
                .creator(UserDto.from(house.getCreator()))
                .createdAt(house.getCreatedAt())
                .description(house.getDescription())
                .houseClass(house.getHouseClass())
                .location(house.getLocation())
                .build();
    }

    public static List<HousesDto> from(List<House> houses) {
        return houses.stream().map(HousesDto::from).collect(Collectors.toList());
    }
}
