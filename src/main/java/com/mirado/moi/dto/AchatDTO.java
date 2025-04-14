package com.mirado.moi.dto;

import lombok.Data;
import java.util.List;

@Data
public class AchatDTO {
    private Long userId;
    private List<DetailDto> details;

    @Data
    public static class DetailDto {
        private Long platId;
        private Long quantite;
    }
}
