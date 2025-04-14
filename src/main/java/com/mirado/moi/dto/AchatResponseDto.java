package com.mirado.moi.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class AchatResponseDto {
    private Long id;
    private String username;
    private Double prixTotal;
    private LocalDateTime createdAt;
    private List<DetailDto> details;

    @Data
    public static class DetailDto {
        private String platNom;
        private Long quantite;
        private Double prixUnitaire;
    }
}
