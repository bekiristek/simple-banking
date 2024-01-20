package com.bekiristek.bankingapp.service.impl;

import com.bekiristek.bankingapp.exceptions.AccountNotFoundException;
import com.bekiristek.bankingapp.exceptions.InsufficientBalanceException;
import com.bekiristek.bankingapp.exceptions.InvalidAmountException;
import com.bekiristek.bankingapp.mapper.AccountMapper;
import com.bekiristek.bankingapp.model.dto.CreateAccountResponseDto;
import com.bekiristek.bankingapp.model.dto.CreateAccountRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateCreditRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateCreditResponseDto;
import com.bekiristek.bankingapp.model.dto.CreatePhoneBillPaymentRequestDto;
import com.bekiristek.bankingapp.model.dto.CreatePhoneBillPaymentResponseDto;
import com.bekiristek.bankingapp.model.dto.CreateWithdrawalRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateWithdrawalResponseDto;
import com.bekiristek.bankingapp.model.entity.Account;
import com.bekiristek.bankingapp.repository.AccountRepository;
import com.bekiristek.bankingapp.service.AccountService;

import com.bekiristek.bankingapp.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;
    private AccountMapper accountMapper;

    @Override
    public CreateAccountResponseDto createAccount(CreateAccountRequestDto createAccountRequestDto) {
        Account account = accountMapper.createAccountRequestDtoToAccount(createAccountRequestDto);
        account.setAccountNumber(createUniqueAccountNumber());
        account.setCreatedDateTime(LocalDateTime.now());
        accountRepository.save(account);
        return accountMapper.createAccountToCreateAccountResponseDto(account);
    }

    @Override
    public CreateCreditResponseDto credit(CreateCreditRequestDto createCreditRequestDto) {

        Account account = accountRepository.findByAccountNumber(createCreditRequestDto.getAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("Girilen hesap numarası bulunamamıştır. Girilen hesap numarası: " + createCreditRequestDto.getAccountNumber()));

        if (createCreditRequestDto.getAmount() <= 0) {
            throw new InvalidAmountException("Girmiş olduğunuz tutar bilgisi geçersizdir. Tutar: " + createCreditRequestDto.getAmount());
        }
        account.setBalance(account.getBalance() + createCreditRequestDto.getAmount());
        accountRepository.save(account);
        transactionService.deposit(account, createCreditRequestDto.getAmount());
        return accountMapper.createAccountToCreateCreditResponseDto(account);

    }

    @Override
    public CreateWithdrawalResponseDto debit(CreateWithdrawalRequestDto createWithdrawalRequestDto) {

        Account account = accountRepository.findByAccountNumber(createWithdrawalRequestDto.getAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("Girilen hesap numarası bulunamamıştır. Girilen hesap numarası: " + createWithdrawalRequestDto.getAccountNumber()));

        if (account.getBalance() < createWithdrawalRequestDto.getAmount()) {
            throw new InsufficientBalanceException("Bakiyeniz yeterli değildir. Bakiyeniz: " + account.getBalance());
        }
        account.setBalance(account.getBalance() - createWithdrawalRequestDto.getAmount());
        accountRepository.save(account);
        transactionService.withdrawal(account, createWithdrawalRequestDto.getAmount());
        return accountMapper.createAccountToCreateWithdrawalResponseDto(account);
    }

    @Override
    public CreatePhoneBillPaymentResponseDto payment(CreatePhoneBillPaymentRequestDto createPhoneBillPaymentRequestDto) {

        Account account = accountRepository.findByAccountNumber(createPhoneBillPaymentRequestDto.getAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("Girilen hesap numarası bulunamamıştır. Girilen hesap numarası: " + createPhoneBillPaymentRequestDto.getAccountNumber()));
        if (account.getBalance() < createPhoneBillPaymentRequestDto.getAmount()) {
            throw new InsufficientBalanceException("Bakiyeniz yeterli değildir. Bakiyeniz: " + account.getBalance());
        }
        account.setBalance(account.getBalance() - createPhoneBillPaymentRequestDto.getAmount());
        accountRepository.save(account);
        transactionService.payment(account, createPhoneBillPaymentRequestDto);
        return accountMapper.createAccountToCreatePhoneBillPaymentResponseDto(account);
    }

    @Override
    public CreateAccountResponseDto getByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException("Girilen hesap numarası bulunamamıştır. Girilen hesap numarası: " + accountNumber));

        return accountMapper.createAccountToCreateAccountResponseDto(account);
    }

    private String createUniqueAccountNumber() {
        String accountNumber;
        do {
            String randomNumber = generateAccountNumber();
            accountNumber = randomNumber.substring(0, 3) + "-" + randomNumber.substring(3, 6) + "-" + randomNumber.substring(6);
        } while (isUniqueAccountNumber(accountNumber));
        return accountNumber;
    }


    private String generateAccountNumber() {
        Random random = new Random();
        // 10 basamaklı banka hesap numarasını oluşturmak için
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int randomBasamak = random.nextInt(10);
            accountNumber.append(randomBasamak);
        }
        return accountNumber.toString();
    }

    private boolean isUniqueAccountNumber(String accountNumber) {
        Optional<Account> existingAccount = accountRepository.findByAccountNumber(accountNumber);
        return existingAccount.isPresent();
    }
}
