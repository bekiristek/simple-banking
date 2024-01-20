package com.bekiristek.bankingapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateWithdrawalResponseDto {
    private String owner;
    private String accountNumber;
    private double balance;
}
