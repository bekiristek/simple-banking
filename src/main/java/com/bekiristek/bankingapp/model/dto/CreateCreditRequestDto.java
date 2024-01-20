package com.bekiristek.bankingapp.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCreditRequestDto {
    @NotNull(message = "Hesap numarası alanı zorunludur.")
    @NotBlank(message = "Hesap numarası alanı zorunludur.")
    private String accountNumber;
    @NotNull(message = "Tutar alanı zorunludur.")
    private double amount;
}
