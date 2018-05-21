package com.earth.validator.impl;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

import com.earth.anno.impl.Regex;
import com.earth.validator.Validator;

public class RegexValidate implements Validator{

	public boolean validate(Field field, Object bean) throws Exception {
		Regex regex = field.getAnnotation(Regex.class);
		String rex = regex.value();
		Pattern p = Pattern.compile(rex);
		if(field.get(bean) == null || !(field.get(bean) instanceof String)) return false;
		return p.matcher(field.get(bean).toString()).matches();
	}

}
