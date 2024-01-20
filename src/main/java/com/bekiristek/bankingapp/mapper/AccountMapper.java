package com.bekiristek.bankingapp.mapper;

import com.bekiristek.bankingapp.model.dto.CreateAccountResponseDto;
import com.bekiristek.bankingapp.model.dto.CreateAccountRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateCreditRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateCreditResponseDto;
import com.bekiristek.bankingapp.model.dto.CreatePhoneBillPaymentRequestDto;
import com.bekiristek.bankingapp.model.dto.CreatePhoneBillPaymentResponseDto;
import com.bekiristek.bankingapp.model.dto.CreateWithdrawalRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateWithdrawalResponseDto;
import com.bekiristek.bankingapp.model.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account createAccountRequestDtoToAccount(CreateAccountRequestDto createAccountRequestDto);

    CreateAccountResponseDto createAccountToCreateAccountResponseDto(Account account);

    Account createCreditRequestDtoToAccount(CreateCreditRequestDto createCreditRequestDto);

    CreateCreditResponseDto createAccountToCreateCreditResponseDto(Account account);

    Account createWithdrawalRequestDtoToAccount(CreateWithdrawalRequestDto createWithdrawalRequestDto);

    CreateWithdrawalResponseDto createAccountToCreateWithdrawalResponseDto(Account account);

    Account createPhoneBillPaymentRequestDtoToAccount(CreatePhoneBillPaymentRequestDto createPhoneBillPaymentRequestDto);

    CreatePhoneBillPaymentResponseDto createAccountToCreatePhoneBillPaymentResponseDto(Account account);
}
