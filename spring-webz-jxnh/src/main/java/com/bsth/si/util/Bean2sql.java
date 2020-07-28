package com.bsth.si.util;


public class Bean2sql {

	public Bean2sql() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String getSqlName(String word) {
		// String word = "birthDate";
		String newWord = "";
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!Character.isLowerCase(c)) {
				newWord = newWord + "_" + c;
			} else {
				newWord = newWord + c;
			}
		}
		// System.out.println(newWord);
		return newWord.toUpperCase();
	}
}
