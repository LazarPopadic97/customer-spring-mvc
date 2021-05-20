/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.application.customerspringmvc.dao.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rs.fon.silab.application.customerspringmvc.dao.Dao;
import rs.fon.silab.application.customerspringmvc.domain.City;

/**
 *
 * @author Korisnik
 */
@Repository
public class CityDaoImpl implements Dao<City> {

    //uzmi konekciju
    EntityManagerFactory emf;
    EntityManager em;

    public CityDaoImpl() {
        
    }

    @Override
    public void save(City city) throws Exception {
        emf = Persistence.createEntityManagerFactory("njt_2021");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            //proveri da li grad sa postanskim brojem postoji u bazi
            City existingCity = em.find(City.class, city.getCode());
            if (existingCity == null) {
                em.persist(city);
                em.getTransaction().commit();
                System.out.println("City is saved!");
            } else {
                System.out.println("City already exist, update city!");
                existingCity.setName(city.getName());
                em.getTransaction().commit();
                System.out.println("City is updated!");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }

    }

    @Override
    public List<City> getAll() {
        emf = Persistence.createEntityManagerFactory("njt_2021");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            CriteriaQuery<City> criteria = em.getCriteriaBuilder().createQuery(City.class);
            criteria.select(criteria.from(City.class));
            List<City> cities = em.createQuery(criteria).getResultList();
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
        return null;
    }

    @Override
    public City getByCode(Long l) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("njt_2021");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            //em.remove(city);
            City existingCity = em.find(City.class, l);
            return existingCity;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
        return null;
    }

    @Override
    public void deleteCity(Long l) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("njt_2021");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            //em.remove(city);
            City existingCity = em.find(City.class, l);
            if (existingCity == null) {
                System.out.println("City does not exist!");
            } else {
                em.remove(existingCity);
                em.getTransaction().commit();
                System.out.println("City is removed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

}
