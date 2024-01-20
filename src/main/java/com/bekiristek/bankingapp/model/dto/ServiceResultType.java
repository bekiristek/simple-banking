package com.bekiristek.bankingapp.model.dto;

public enum ServiceResultType {

    SUCCESS(200),

    ERROR(500);

    private int status;

    private ServiceResultType(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return this.status == 200;
    }

}
