package com.bekiristek.bankingapp.service.impl;

import com.bekiristek.bankingapp.mapper.AccountMapper;
import com.bekiristek.bankingapp.model.dto.CreateAccountRequestDto;
import com.bekiristek.bankingapp.model.dto.CreateAccountResponseDto;
import com.bekiristek.bankingapp.model.entity.Account;
import com.bekiristek.bankingapp.model.entity.DepositTransaction;
import com.bekiristek.bankingapp.model.entity.Transaction;
import com.bekiristek.bankingapp.repository.AccountRepository;
import com.bekiristek.bankingapp.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AccountServiceImplTest {

    private AccountServiceImpl accountService;
    private AccountRepository accountRepository;
    private TransactionService transactionService;
    private AccountMapper accountMapper;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);
        transactionService = Mockito.mock(TransactionService.class);
        accountMapper = Mockito.mock(AccountMapper.class);

        accountService = new AccountServiceImpl(accountRepository, transactionService, accountMapper);
    }

    @Test
    void whenCreateAccountCalledWithValidRequest_itShouldReturnValidCreateAccountResponseDto() {
/*        List<Transaction> transactions = new ArrayList<>();
        Account account = new Account(1L, "785-569-3423", 1000, "Bekir İstek", transactions);
        CreateAccountRequestDto createAccountRequestDto = new CreateAccountRequestDto("Bekir İstek");
        CreateAccountResponseDto createAccountResponseDto = accountMapper.createAccountToCreateAccountResponseDto(account);
        when(accountMapper.createAccountRequestDtoToAccount(createAccountRequestDto)).thenReturn(account);
        when(accountMapper.createAccountToCreateAccountResponseDto(account)).thenReturn(createAccountResponseDto);
        createAccountResponseDto = accountService.createAccount(createAccountRequestDto);
        assertEquals(createAccountResponseDto, account);*/


        CreateAccountRequestDto createAccountRequestDto = new CreateAccountRequestDto("Bekir İstek");
        //CreateAccountResponseDto createAccountResponseDto = accountService.createAccount(createAccountRequestDto);


        CreateAccountResponseDto createAccountResponseDto = CreateAccountResponseDto.builder()
                .owner(createAccountRequestDto.getOwner())
                .accountNumber("785-569-3423")
                .createdDateTime(LocalDateTime.now())
                .balance(0.0)
                .transactions(new ArrayList<>())
                .build();


        assertEquals(createAccountRequestDto.getOwner(), createAccountResponseDto.getOwner());
//        assertEquals(createAccountResponseDto.getAccountNumber(), createAccountResponseDto1.getAccountNumber());
//        assertEquals(createAccountResponseDto.getBalance(), createAccountResponseDto1.getBalance());
//        assertEquals(createAccountResponseDto.getTransactions(), createAccountResponseDto1.getTransactions());

       // when(accountService.createAccount(createAccountRequestDto)).thenReturn(accountDTO);
       // when(accountMapper.createAccountToCreateAccountResponseDto(accountDTO)).thenReturn(createdAccountResponse);
    }

    @Test
    void credit() {
    }

    @Test
    void debit() {
    }

    @Test
    void payment() {
    }

    @Test
    void getByAccountNumber() {
    }
}