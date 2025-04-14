package com.mirado.moi.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

import com.mirado.moi.entity.Plat;

@Stateless
public class PlatRepository {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public void save(Plat plat) {
        em.persist(plat);
    }

    public Plat findById(Long id) {
        return em.find(Plat.class, id);
    }

    public List<Plat> findAll() {
        return em.createQuery("SELECT p FROM Plat p", Plat.class).getResultList();
    }

    public Plat update(Plat plat) {
        return em.merge(plat);
    }

    public void delete(Long id) {
        Plat plat = em.find(Plat.class, id);
        if (plat != null) {
            em.remove(plat);
        }
    }
}
