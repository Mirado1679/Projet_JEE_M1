package com.mirado.moi.service;

import com.mirado.moi.entity.Livreur;
import com.mirado.moi.repository.LivreurRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class LivreurService {

    @Inject
    private LivreurRepository repository;

    public void create(Livreur livreur) {
        repository.save(livreur);
    }

    public Livreur getById(Long id) {
        return repository.findById(id);
    }

    public List<Livreur> getAll() {
        return repository.findAll();
    }

    public Livreur update(Livreur livreur) {
        return repository.update(livreur);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
