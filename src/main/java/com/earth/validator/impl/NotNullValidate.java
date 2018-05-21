package com.earth.validator.impl;

import java.lang.reflect.Field;

import com.earth.validator.Validator;

public class NotNullValidate implements Validator{

	public boolean validate(Field field, Object bean) throws Exception {
		return field.get(bean) == null ? false : true;
	}

}
