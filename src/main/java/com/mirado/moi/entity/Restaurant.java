package com.mirado.moi.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_sequence", allocationSize = 1)
    private Long id;

    private String nom_restaut;
    private String descri_restaut;
    private String adresse_restaut;

    @Column(nullable = true)
    private Long rating;

    private String name;
    private String type;

    private String image;
}
