package com.bekiristek.bankingapp.controller;

import com.bekiristek.bankingapp.model.dto.CreateAccountResponseDto;
import com.bekiristek.bankingapp.model.dto.CreateAccountRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateCreditRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateCreditResponseDto;
import com.bekiristek.bankingapp.model.dto.CreatePhoneBillPaymentRequestDto;
import com.bekiristek.bankingapp.model.dto.CreatePhoneBillPaymentResponseDto;
import com.bekiristek.bankingapp.model.dto.CreateWithdrawalRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateWithdrawalResponseDto;
import com.bekiristek.bankingapp.service.AccountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
@AllArgsConstructor
@Validated
public class AccountController {
    private AccountService accountService;

    @PostMapping("/create")
    public CreateAccountResponseDto createAccount(@RequestBody @Valid CreateAccountRequestDto createAccountRequestDto) {
        return accountService.createAccount(createAccountRequestDto);
    }

    @GetMapping("/{accountNumber}")
    public CreateAccountResponseDto getByAccountNumber(@PathVariable String accountNumber){
        return accountService.getByAccountNumber(accountNumber);
    }

    @PostMapping("/credit")
    public CreateCreditResponseDto credit(@RequestBody @Valid CreateCreditRequestDto createCreditRequestDto) {
        return accountService.credit(createCreditRequestDto);
    }

    @PostMapping("/debit")
    public CreateWithdrawalResponseDto debit(@RequestBody @Valid CreateWithdrawalRequestDto createWithdrawalRequestDto) {
        return accountService.debit(createWithdrawalRequestDto);
    }

    @PostMapping("/payment")
    public CreatePhoneBillPaymentResponseDto payment(@RequestBody @Valid CreatePhoneBillPaymentRequestDto createPhoneBillPaymentRequestDto) {
        return accountService.payment(createPhoneBillPaymentRequestDto);
    }
}
