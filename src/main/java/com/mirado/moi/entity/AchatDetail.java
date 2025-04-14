package com.mirado.moi.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AchatDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "achat_detail_seq")
    @SequenceGenerator(name = "achat_detail_seq", sequenceName = "achat_detail_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    private Achat achat;

    @ManyToOne
    private Plat plat;

    private Long quantite;
}
