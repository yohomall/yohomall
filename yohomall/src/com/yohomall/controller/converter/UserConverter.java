package com.yohomall.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<String, Date>{

	@Override
	public Date convert(String resouce) {
		//将字符串转成日期类型
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
		try {
			//转换成功返回
			return simpleDateFormat.parse(resouce);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//转换失败返回null
		return null;
	}

}
