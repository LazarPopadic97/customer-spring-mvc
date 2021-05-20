/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.application.customerspringmvc.service;

import java.util.List;
import rs.fon.silab.application.customerspringmvc.domain.City;
import rs.fon.silab.application.customerspringmvc.dto.CityDto;

/**
 *
 * @author Korisnik
 */
public interface CityService {

    CityDto save(CityDto cityDto) throws Exception;
    
    List<CityDto> getAll()throws Exception;

    public CityDto getByCode(Long cityCode);

    public void deleteCity(Long cityCode);
}
