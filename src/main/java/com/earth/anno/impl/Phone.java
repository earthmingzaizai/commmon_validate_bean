package com.earth.anno.impl;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.earth.anno.ValidateField;
import com.earth.validator.impl.PhoneValidator;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@ValidateField(PhoneValidator.class)
public @interface Phone {

}
