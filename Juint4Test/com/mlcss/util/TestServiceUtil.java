package com.mlcss.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import sun.misc.BASE64Encoder;


public class TestServiceUtil {

	@Test
	public void testToMD5() {
		System.out.println(ServiceUtil.toMD5("123"));
		System.out.println(ServiceUtil.toMD5("123"));
	}
}
