package com.yohomall.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<String, Date>{

	@Override
	public Date convert(String resouce) {
		//���ַ���ת����������
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//ת���ɹ�����
			return simpleDateFormat.parse(resouce);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ת��ʧ�ܷ���null
		return null;
	}

}
