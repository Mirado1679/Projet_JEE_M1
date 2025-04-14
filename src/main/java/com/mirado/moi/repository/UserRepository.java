package com.mirado.moi.repository;

import java.util.List;

import com.mirado.moi.entity.User;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class UserRepository {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager entityManager;

    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    public User findByEmail(String email) {
        try {
            return entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

}
