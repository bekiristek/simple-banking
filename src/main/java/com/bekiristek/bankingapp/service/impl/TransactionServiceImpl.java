package com.bekiristek.bankingapp.service.impl;

import com.bekiristek.bankingapp.model.dto.CreatePhoneBillPaymentRequestDto;
import com.bekiristek.bankingapp.model.entity.Account;
import com.bekiristek.bankingapp.model.entity.DepositTransaction;
import com.bekiristek.bankingapp.model.entity.PhoneBillPaymentTransaction;
import com.bekiristek.bankingapp.model.entity.Transaction;
import com.bekiristek.bankingapp.model.entity.WithdrawalTransaction;
import com.bekiristek.bankingapp.model.enums.TransactionType;
import com.bekiristek.bankingapp.repository.TransactionRepository;
import com.bekiristek.bankingapp.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public void deposit(Account account, double amount) {
        String approvalCode = UUID.randomUUID().toString();
        Transaction transaction = new DepositTransaction(amount);
        transaction.setAccount(account);
        transaction.setApprovalCode(approvalCode);
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transactionRepository.save(transaction);
    }

    @Override
    public void withdrawal(Account account, double amount) {
        String approvalCode = UUID.randomUUID().toString();
        Transaction transaction = new WithdrawalTransaction(amount);
        transaction.setAccount(account);
        transaction.setApprovalCode(approvalCode);
        transaction.setTransactionType(TransactionType.WITHDRAW);
        transactionRepository.save(transaction);
    }

    @Override
    public void payment(Account account, CreatePhoneBillPaymentRequestDto createPhoneBillPaymentRequestDto) {
        String approvalCode = UUID.randomUUID().toString();
        Transaction transaction = new PhoneBillPaymentTransaction(createPhoneBillPaymentRequestDto.getAccountNumber(), createPhoneBillPaymentRequestDto.getPhoneNumber(), createPhoneBillPaymentRequestDto.getAmount());
        transaction.setAccount(account);
        transaction.setApprovalCode(approvalCode);
        transaction.setTransactionType(TransactionType.PHONE_BILL_PAYMENT);
        transactionRepository.save(transaction);
    }
}
