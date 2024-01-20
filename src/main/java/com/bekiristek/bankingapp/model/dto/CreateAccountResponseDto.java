package com.bekiristek.bankingapp.model.dto;

import com.bekiristek.bankingapp.model.entity.Transaction;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateAccountResponseDto {

    private String accountNumber;

    private String owner;

    private Double balance;

    private LocalDateTime createdDateTime;

    List<Transaction> transactions;

}
