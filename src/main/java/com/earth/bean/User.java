package com.earth.bean;

import com.earth.anno.impl.Phone;
import com.earth.anno.impl.Regex;

import lombok.Data;
@Data
public class User {
	@Regex("张")
	private String name;
	
	private String email;
	@Phone
	private String phone;
	
}
