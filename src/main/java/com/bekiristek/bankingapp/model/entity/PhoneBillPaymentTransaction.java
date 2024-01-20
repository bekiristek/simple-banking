package com.bekiristek.bankingapp.model.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class PhoneBillPaymentTransaction extends Transaction {
    private String phoneNumber;

    public PhoneBillPaymentTransaction(String accountNumber, String phoneNumber, double amount) {
        super(amount);
        this.phoneNumber = phoneNumber;
    }
}
