package com.bekiristek.bankingapp.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAccountRequestDto {
    @NotNull(message = "Kişi bilgisi boş olamaz.")
    @NotBlank(message = "Kişi bilgisi boş olamaz.")
    private String owner;
}
