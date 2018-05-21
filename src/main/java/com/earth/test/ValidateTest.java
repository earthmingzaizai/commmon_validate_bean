package com.earth.test;

import org.junit.Test;

import com.earth.bean.User;
import com.earth.utils.ValidateUtils;

public class ValidateTest {
	
	@Test
	public void test01() {
		long start = System.currentTimeMillis();
		User user = new User();
		user.setName("张");
		boolean b = ValidateUtils.validate(user);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
