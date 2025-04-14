package com.mirado.moi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Achat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "achat_seq")
    @SequenceGenerator(name = "achat_seq", sequenceName = "achat_sequence", allocationSize = 1)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "achat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AchatDetail> details;

    private Double prix_total;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public void setPrixTotal() {
        if (details != null) {
            this.prix_total = details.stream()
                    .mapToDouble(d -> {
                        if (d.getPlat() == null || d.getPlat().getPrix() == null || d.getQuantite() == null) {
                            return 0.0;
                        }
                        return d.getPlat().getPrix() * d.getQuantite();
                    })
                    .sum();
        } else {
            this.prix_total = 0.0;
        }
    }

}
