package com.nelioalves.curso_mc.services.validation;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;


@Constraint(validatedBy = ClienteUpdateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ClienteUpdate {

    String message() default "Erro de validação";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
