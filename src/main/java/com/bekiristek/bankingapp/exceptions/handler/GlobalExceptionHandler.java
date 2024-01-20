package com.bekiristek.bankingapp.exceptions.handler;

import com.bekiristek.bankingapp.exceptions.AccountNotFoundException;
import com.bekiristek.bankingapp.exceptions.CustomRuntimeException;
import com.bekiristek.bankingapp.exceptions.InsufficientBalanceException;
import com.bekiristek.bankingapp.exceptions.InvalidAmountException;
import com.bekiristek.bankingapp.model.dto.ErrorDto;
import com.bekiristek.bankingapp.model.dto.ServiceResultDto;
import com.bekiristek.bankingapp.model.dto.ServiceResultStatusCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ServiceResultDto<Void>> accountNotFoundException(AccountNotFoundException e) {
        ErrorDto error = ErrorDto.builder()
                .message(e.getCode())
                .build();
        return ResponseEntity.ok(new ServiceResultDto<>(error, ServiceResultStatusCode.ACCOUNT_NOT_FOUND));
    }

    @ExceptionHandler(InvalidAmountException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ServiceResultDto<Void>> undefinedAmountException(InvalidAmountException e) {
        ErrorDto error = ErrorDto.builder()
                .message(e.getCode())
                .build();
        return ResponseEntity.ok(new ServiceResultDto<>(error, ServiceResultStatusCode.INVALID_AMOUNT));
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ServiceResultDto<Void>> insufficientBalanceException(InsufficientBalanceException e) {
        ErrorDto error = ErrorDto.builder()
                .message(e.getCode())
                .build();
        return ResponseEntity.ok(new ServiceResultDto<>(error, ServiceResultStatusCode.INSUFFICIENT_BALANCE));
    }

    @ExceptionHandler(CustomRuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ServiceResultDto<Void>> customRuntimeException(CustomRuntimeException e) {
        ErrorDto error = ErrorDto.builder()
                .message(e.getMessage())
                .build();
        return ResponseEntity.ok(ServiceResultDto.error(error));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ServiceResultDto<Void>> generalException(Exception e) {
        ErrorDto error = ErrorDto.builder()
                .message(e.getMessage())
                .build();
        return ResponseEntity.ok(ServiceResultDto.error(error));
    }
}
