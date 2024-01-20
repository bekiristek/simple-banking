package com.bekiristek.bankingapp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Builder
public class ServiceResultDto<T> implements Serializable {

    private T data;

    private ServiceResultType resultType;

    private List<ErrorDto> errors;

    private int statusCode;

    public ServiceResultDto() {
    }

    public ServiceResultDto(T data) {
        this(data, ServiceResultType.SUCCESS, null, ServiceResultStatusCode.SUCCESS);
    }

    public ServiceResultDto(List<ErrorDto> errors) {
        this(errors, ServiceResultStatusCode.ERROR);
    }

    public ServiceResultDto(List<ErrorDto> errors, int statusCode) {
        this(null, ServiceResultType.ERROR, errors, statusCode);
    }

    public ServiceResultDto(ErrorDto error, int statusCode) {
        this(null, ServiceResultType.ERROR, Collections.singletonList(error), statusCode);
    }

    public ServiceResultDto(T data, ServiceResultType resultType, List<ErrorDto> errors, int statusCode) {
        this.data = data;
        this.resultType = resultType;
        this.errors = errors;
        this.statusCode = statusCode;
    }

    @JsonProperty("isSuccess")
    public boolean isSuccess() {
        return this.resultType.isSuccess();
    }

    public static <T> ServiceResultDto<T> success(T data) {
        return new ServiceResultDto<>(data);
    }

    public static ServiceResultDto<Void> error(ErrorDto... errors) {
        return new ServiceResultDto<>(Arrays.stream(errors).toList());
    }
}