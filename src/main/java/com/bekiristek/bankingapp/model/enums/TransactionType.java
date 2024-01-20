package com.bekiristek.bankingapp.model.enums;

public enum TransactionType {

    WITHDRAW(1, "WithdrawalTransaction"),
    DEPOSIT(2, "DepositTransaction"),
    PHONE_BILL_PAYMENT(3, "PhoneBillPaymentTransaction");

    private int code;
    private String name;

    TransactionType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return name;
    }
}
