/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.application.customerspringmvc.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.fon.silab.application.customerspringmvc.dao.Dao;
import rs.fon.silab.application.customerspringmvc.domain.City;
import rs.fon.silab.application.customerspringmvc.dto.CityDto;
import rs.fon.silab.application.customerspringmvc.mapper.impl.CityMapper;
import rs.fon.silab.application.customerspringmvc.service.CityService;

/**
 *
 * @author Korisnik
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final Dao<City> cityDao;
    private final CityMapper cityMapper;

    @Autowired
    public CityServiceImpl(Dao<City> cityDao, CityMapper cityMapper) {
        this.cityDao = cityDao;
        this.cityMapper = cityMapper;
    }

    @Override
    public CityDto save(CityDto cityDto) throws Exception {
        System.out.println("Service : save");
        cityDao.save(cityMapper.toEntity(cityDto));
        return cityDto;
    }

    @Override
    public List<CityDto> getAll() throws Exception {
        List<City> cities = cityDao.getAll();
        List<CityDto> citiesDto = new ArrayList<>();

        citiesDto = cities.stream().map(city -> {
            return cityMapper.toDto(city);
        }).collect(Collectors.toList());

        return citiesDto;

        /*return cities
                .stream().map(city -> {
                    return cityMapper.toDto(city);
                }).collect(Collectors.toList()
        );*/
    }

    @Override
    public CityDto getByCode(Long l) {
        return cityMapper.toDto(cityDao.getByCode(l));
    }

    @Override
    public void deleteCity(Long l) {
        cityDao.deleteCity(l);
    }

}
