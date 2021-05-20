/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.application.customerspringmvc.dao;

import java.util.List;
import rs.fon.silab.application.customerspringmvc.domain.City;
import rs.fon.silab.application.customerspringmvc.domain.Entity;

/**
 *
 * @author korisnik
 */
public interface Dao<T extends Entity> {

    void save(T e) throws Exception;

    List<T> getAll();

    public City getByCode(Long l);

    public void deleteCity(Long l);
}
