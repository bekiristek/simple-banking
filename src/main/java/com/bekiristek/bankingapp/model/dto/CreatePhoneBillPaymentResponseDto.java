package com.bekiristek.bankingapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePhoneBillPaymentResponseDto {
    private String accountNumber;
    private double balance;

}
