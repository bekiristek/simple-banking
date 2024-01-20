package com.bekiristek.bankingapp.validator.annotations;

import com.bekiristek.bankingapp.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface PhoneNumber {

    String message() default "Telefon bilgisi eksik veya hatalı.!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
