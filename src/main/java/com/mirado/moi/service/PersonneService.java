/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mirado.moi.service;

/**
 *
 * @author Tsiory
 */
import com.mirado.moi.entity.Personne;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class PersonneService {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    public void ajouter(Personne p) {
        em.persist(p);
    }

    public List<Personne> lister() {
        return em.createQuery("SELECT p FROM Personne p", Personne.class).getResultList();
    }
}

