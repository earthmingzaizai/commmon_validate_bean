package com.earth.validator.impl;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import com.earth.validator.Validator;

public class PhoneValidator implements Validator {

	public boolean validate(Field field, Object bean) throws Exception {
		String regex = "(\\d{0,2})?(0\\d{1,4})?(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})+(\\-[0-9]{1,4})?|(0|86|17951)?(13[0-9]|15[012356789]|17[01678]|18[0-9]|14[57])[0-9]{8}";
		Pattern p = Pattern.compile(regex);
		Object obj = field.get(bean);
		if(obj == null || !(obj instanceof String)) return false;
		return p.matcher(obj.toString()).matches();
	}

}
