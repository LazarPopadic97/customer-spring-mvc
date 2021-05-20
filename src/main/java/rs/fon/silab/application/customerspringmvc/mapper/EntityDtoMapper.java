/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.application.customerspringmvc.mapper;

import java.util.List;
import rs.fon.silab.application.customerspringmvc.domain.Entity;
import rs.fon.silab.application.customerspringmvc.dto.Dto;

/**
 *
 * @author korisnik
 */
public interface EntityDtoMapper<D extends Dto, E extends Entity> {

    D toDto(E entity);

    E toEntity(D dto);

}
