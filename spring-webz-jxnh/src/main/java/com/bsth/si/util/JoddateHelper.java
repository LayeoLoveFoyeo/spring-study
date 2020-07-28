package com.bsth.si.util;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.joda.time.DateTime;

public class JoddateHelper {
	public static void main(String[] args) throws ParseException {
		Date data = new Date();
		DateTime dateTime = new DateTime(data);
		System.out.println(dateTime.toString("yyyy-MM-dd"));
		System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
		System.out.println(dateTime+"");
		System.out.println(new DateTime(dateTime+"").toDate());
		System.out.println(new DateTime("2012-06-11T10:58:21").toDate());
		System.out.println(new DateTime("2012-06-11").toDate());
		System.out.println(new DateTime(getFormatStr("2012-4-28  15:11:00")).toDate());
		System.out.println(DateFormat.getDateInstance().parse("2012-4-28  15:11:00"));
		System.out.println(DateFormat.getDateInstance().parse("2012-4-28"));
		System.out.println(new DateTime().toDate());
		
	}
	
	public static String getFormatStr(String dateStr){
		String[] dateA = dateStr.split(" ");
		String newDateStr = dateA[0]+"T"+dateA[dateA.length-1];
		return newDateStr;
	}
}
