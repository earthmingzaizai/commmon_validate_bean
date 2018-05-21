package com.earth.validator.impl;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import com.earth.validator.Validator;

public class EmailValidator implements Validator{

	private String regex = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";

	public boolean validate(Field field, Object bean) throws Exception {
		Pattern p = Pattern.compile(regex);
		Object val = field.get(bean);
		if(field.get(bean) == null || !(field.get(bean) instanceof String)) return false;
		return p.matcher(val.toString()).matches();
	}

}
