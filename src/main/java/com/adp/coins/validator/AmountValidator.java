package com.adp.coins.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.stream.Collectors;

@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AmountValidator.Validator.class)
public @interface AmountValidator {

    String message() default "Amount should be from the list of ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String[] values();


    class Validator implements ConstraintValidator<AmountValidator, Integer>{
        private String[] values;
        private String message;

        @Override
        public void initialize(AmountValidator a){
            values = a.values();
            message = a.message();
            System.out.println(values);
        }
        @Override
        public boolean isValid(Integer amount, ConstraintValidatorContext constraintValidatorContext) {
            if(Arrays.stream(values).anyMatch(e -> e.equals(String.valueOf(amount)))){
                return true;
            }else{
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(message.concat(Arrays.stream(values).collect(Collectors.joining(",")))).addConstraintViolation();
                return false;
            }
        }
    }
}
