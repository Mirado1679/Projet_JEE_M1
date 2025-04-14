package com.mirado.moi.repository;

import com.mirado.moi.entity.Restaurant;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class RestaurantRepository {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public void save(Restaurant restaurant) {
        em.persist(restaurant);
    }

    public Restaurant findById(Long id) {
        return em.find(Restaurant.class, id);
    }

    public List<Restaurant> findAll() {
        return em.createQuery("SELECT r FROM Restaurant r", Restaurant.class).getResultList();
    }

    public Restaurant update(Restaurant restaurant) {
        return em.merge(restaurant);
    }

    public void delete(Long id) {
        Restaurant r = em.find(Restaurant.class, id);
        if (r != null)
            em.remove(r);
    }
}
