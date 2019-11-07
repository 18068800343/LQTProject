package com.ldxx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetThisTimeUtils {
	
	public static String getTime(){
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}

}
