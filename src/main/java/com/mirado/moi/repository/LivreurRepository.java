package com.mirado.moi.repository;

import com.mirado.moi.entity.Livreur;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class LivreurRepository {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public void save(Livreur livreur) {
        em.persist(livreur);
    }

    public Livreur findById(Long id) {
        return em.find(Livreur.class, id);
    }

    public List<Livreur> findAll() {
        return em.createQuery("SELECT l FROM Livreur l", Livreur.class).getResultList();
    }

    public Livreur update(Livreur livreur) {
        return em.merge(livreur);
    }

    public void delete(Long id) {
        Livreur livreur = em.find(Livreur.class, id);
        if (livreur != null) {
            em.remove(livreur);
        }
    }
}
