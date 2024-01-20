package com.bekiristek.bankingapp.exceptions;

public class CustomRuntimeException extends RuntimeException {

    private String code;

    private String defaultMessage;

    private Object[] args;

    public CustomRuntimeException(String code) {
        this(code, null);
    }

    public CustomRuntimeException(String code, Object[] args) {
        this(code, null, args);
    }

    public CustomRuntimeException(String code, String defaultMessage, Object[] args) {
        super(defaultMessage);
        this.code = code;
        this.defaultMessage = defaultMessage;
        this.args = args;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
