package com.mirado.moi.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import com.mirado.moi.entity.Achat;

@Stateless
public class AchatRepository {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public void save(Achat achat) {
        achat.setPrixTotal();
        em.persist(achat);
    }

    public Achat findById(Long id) {
        return em.find(Achat.class, id);
    }

    public List<Achat> findAll() {
        return em.createQuery("SELECT a FROM Achat a", Achat.class).getResultList();
    }

    public Achat update(Achat achat) {
        achat.setPrixTotal();
        return em.merge(achat);
    }

    public void delete(Long id) {
        Achat achat = em.find(Achat.class, id);
        if (achat != null) {
            em.remove(achat);
        }
    }
}
