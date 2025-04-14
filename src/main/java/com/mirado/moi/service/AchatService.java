package com.mirado.moi.service;

import com.mirado.moi.dto.AchatDTO;
import com.mirado.moi.dto.AchatResponseDto;
import com.mirado.moi.entity.*;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class AchatService {

    @PersistenceContext
    private EntityManager em;

    public void createFromDto(AchatDTO dto) {
        Achat achat = new Achat();
        User user = em.find(User.class, dto.getUserId());
        achat.setUser(user);

        List<AchatDetail> details = dto.getDetails().stream().map(d -> {
            Plat plat = em.find(Plat.class, d.getPlatId());
            return AchatDetail.builder()
                    .achat(achat)
                    .plat(plat)
                    .quantite(d.getQuantite())
                    .build();
        }).toList();

        achat.setDetails(details);
        achat.setPrixTotal();

        em.persist(achat);
    }

    public AchatResponseDto toDto(Achat achat) {
        AchatResponseDto dto = new AchatResponseDto();
        dto.setId(achat.getId());
        dto.setUsername(achat.getUser().getFullName());
        dto.setPrixTotal(achat.getPrix_total());
        dto.setCreatedAt(achat.getCreatedAt());

        List<AchatResponseDto.DetailDto> detailDtos = achat.getDetails().stream().map(detail -> {
            AchatResponseDto.DetailDto d = new AchatResponseDto.DetailDto();
            d.setPlatNom(detail.getPlat().getNom_plat());
            d.setPrixUnitaire(detail.getPlat().getPrix());
            d.setQuantite(detail.getQuantite());
            return d;
        }).toList();

        dto.setDetails(detailDtos);
        return dto;
    }

    public List<AchatResponseDto> getAllAsDto() {
        return getAll().stream()
                .map(this::toDto)
                .toList();
    }

    public List<Achat> getAll() {
        return em.createQuery("SELECT a FROM Achat a", Achat.class).getResultList();
    }

    public Achat getById(Long id) {
        return em.find(Achat.class, id);
    }

    public Achat update(Achat achat) {
        achat.setPrixTotal();
        return em.merge(achat);
    }

    public void delete(Long id) {
        Achat achat = em.find(Achat.class, id);
        if (achat != null)
            em.remove(achat);
    }
}
