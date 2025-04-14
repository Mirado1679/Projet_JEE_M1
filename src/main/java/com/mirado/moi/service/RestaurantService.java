package com.mirado.moi.service;

import com.mirado.moi.entity.Restaurant;
import com.mirado.moi.repository.RestaurantRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class RestaurantService {

    @Inject
    private RestaurantRepository repository;

    public void create(Restaurant r) {
        repository.save(r);
    }

    public Restaurant get(Long id) {
        return repository.findById(id);
    }

    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    public Restaurant update(Restaurant r) {
        return repository.update(r);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}
