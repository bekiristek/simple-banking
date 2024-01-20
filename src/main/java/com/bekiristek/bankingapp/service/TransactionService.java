package com.bekiristek.bankingapp.service;

import com.bekiristek.bankingapp.model.dto.CreatePhoneBillPaymentRequestDto;
import com.bekiristek.bankingapp.model.entity.Account;

public interface TransactionService {
    void deposit(Account account, double amount);

    void withdrawal(Account account, double amount);

    void payment(Account account, CreatePhoneBillPaymentRequestDto createPhoneBillPaymentRequestDto);
}
