package com.mlcss.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * 一些用到的工具包
 * md5编码
 * test2
 * @author fantasy
 *
 */

public class ServiceUtil {

	/**
	 * md5 数据摘要+base64加密返回
	 * @param source 待加密字符串
	 * @return base64加密字符串
	 */
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
