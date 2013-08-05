package com.mlcss.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
	
	public  static String date2String(Date date) {
		return sdf.format(date);
	}
	
	public static Timestamp String2Date(String date) {
		try {
			return new Timestamp(sdf.parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
