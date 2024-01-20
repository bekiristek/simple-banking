package com.bekiristek.bankingapp.model.dto;

import com.bekiristek.bankingapp.validator.annotations.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePhoneBillPaymentRequestDto {

    @PhoneNumber
    private String phoneNumber;
    @NotNull(message = "Hesap numarası alanı zorunludur.")
    @NotBlank(message = "Hesap numarası alanı zorunludur.")
    private String accountNumber;
    @NotNull(message = "Tutar alanı zorunludur.")
    private double amount;

}
