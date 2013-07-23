package com.mlcss.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;


public class ServiceUtil {

	public static String toMD5(String source) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] md5 = md.digest(source.getBytes());
			BASE64Encoder base = new BASE64Encoder();
			return base.encode(md5);
		} catch (NoSuchAlgorithmException e) {
			throw new  RuntimeException(e);
		}
		
	}
}
