package com.bekiristek.bankingapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ErrorDto implements Serializable {

    private String message;

    private String field;

    private String code;
}