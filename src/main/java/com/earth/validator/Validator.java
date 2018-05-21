package com.earth.validator;

import java.lang.reflect.Field;

public interface Validator {
	/**
	 * 字段验证方法
	 * @param field 需要验证的字段
	 * @param bean 验证的实例化bean
	 * @return 返回验证成功失败
	 */
	boolean validate(Field field,Object bean) throws Exception;
}
