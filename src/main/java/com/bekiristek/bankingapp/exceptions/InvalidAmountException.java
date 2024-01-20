package com.bekiristek.bankingapp.exceptions;

public class InvalidAmountException extends CustomRuntimeException {

    public InvalidAmountException(String code) {
        super(code);
    }
    public InvalidAmountException(String code, Object... userNameArgs) {
        super(code, userNameArgs);
    }
}
