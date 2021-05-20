/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.application.customerspringmvc.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import rs.fon.silab.application.customerspringmvc.domain.City;
import rs.fon.silab.application.customerspringmvc.dto.CityDto;
import rs.fon.silab.application.customerspringmvc.mapper.EntityDtoMapper;

/**
 *
 * @author korisnik
 */
@Component
public class CityMapper implements EntityDtoMapper<CityDto, City> {

    @Override
    public CityDto toDto(City entity) {
        return new CityDto(entity.getCode(), entity.getName());
    }

    @Override
    public City toEntity(CityDto dto) {
        return new City(dto.getCode(), dto.getName());
    }

}
