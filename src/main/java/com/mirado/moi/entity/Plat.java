package com.mirado.moi.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_sequence", allocationSize = 1)
    private Long id;
    private String nom_plat;
    private String descri_plat;

    private Double prix;
    private Long quantite;
    @ManyToOne
    private Restaurant restaurant;
    private String name;
    private String type;

    private String image;

}
