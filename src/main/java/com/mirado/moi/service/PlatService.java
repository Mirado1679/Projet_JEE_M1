package com.mirado.moi.service;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

import com.mirado.moi.entity.Plat;
import com.mirado.moi.repository.PlatRepository;

@Stateless
public class PlatService {

    @Inject
    private PlatRepository repository;

    public void create(Plat plat) {
        repository.save(plat);
    }

    public Plat getById(Long id) {
        return repository.findById(id);
    }

    public List<Plat> getAll() {
        return repository.findAll();
    }

    public Plat update(Plat plat) {
        return repository.update(plat);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}