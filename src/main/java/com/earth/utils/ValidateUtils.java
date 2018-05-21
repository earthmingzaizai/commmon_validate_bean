package com.earth.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import com.earth.anno.ValidateField;
import com.earth.validator.Validator;

public class ValidateUtils {
	
	public static boolean validate(Object bean) {
		boolean flag = true;
		Field[] fields = bean.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			Annotation[] annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				try {
					Class<? extends Validator> annoVal = null;
					Class<?> clazz = Class.forName(annotation.annotationType().getName());
					if(clazz == ValidateField.class) {
						ValidateField anno = field.getAnnotation(ValidateField.class);
						annoVal = anno.value();
					}else if(clazz.isAnnotationPresent(ValidateField.class)) {
						ValidateField valiAnno = clazz.getDeclaredAnnotation(ValidateField.class);
						annoVal = valiAnno.value();
					}
					
					if(annoVal != null) {
						Validator instance = annoVal.newInstance();
						flag = instance.validate(field, bean);
					}
				} catch (Exception e) {
					flag = false;
					e.printStackTrace();
				}
				if(!flag) return flag;
			}
		}
		return flag;
		
	}
}
