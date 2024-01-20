package com.bekiristek.bankingapp.validator;

import com.bekiristek.bankingapp.validator.annotations.PhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    private static final String PHONE_REGEX = "^5\\d{9}$";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return validatePhoneNumber(s);
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern patternPhone = Pattern.compile(PHONE_REGEX);
        Matcher isMatcherPhone = patternPhone.matcher(phoneNumber);
        return isMatcherPhone.matches();
    }
}