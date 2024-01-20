package com.bekiristek.bankingapp.service;

import com.bekiristek.bankingapp.model.dto.CreateAccountResponseDto;
import com.bekiristek.bankingapp.model.dto.CreateAccountRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateCreditRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateCreditResponseDto;
import com.bekiristek.bankingapp.model.dto.CreatePhoneBillPaymentRequestDto;
import com.bekiristek.bankingapp.model.dto.CreatePhoneBillPaymentResponseDto;
import com.bekiristek.bankingapp.model.dto.CreateWithdrawalRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateWithdrawalResponseDto;

public interface AccountService {
    CreateAccountResponseDto createAccount(CreateAccountRequestDto createAccountRequestDto);

    CreateCreditResponseDto credit(CreateCreditRequestDto createCreditRequestDto);

    CreateWithdrawalResponseDto debit(CreateWithdrawalRequestDto createWithdrawalRequestDto);

    CreatePhoneBillPaymentResponseDto payment(CreatePhoneBillPaymentRequestDto createPhoneBillPaymentRequestDto);

    CreateAccountResponseDto getByAccountNumber(String accountNumber);
}
