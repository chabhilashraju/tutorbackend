package com.tutor4me.user.util;

import java.util.Random;

import javax.servlet.http.HttpServletResponse;

public class Tutor4MeUtils {

	public static String generateID(String letter) {
		Random rnd = new Random();
		char[] digits = new char[9];
		digits[0] = (char) (rnd.nextInt(7) + '1');
		for (int i = 1; i < digits.length; i++) {
			digits[i] = (char) (rnd.nextInt(8) + '0');
		}
		return letter + new String(digits);
	}

	public static void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Amz-Date,Authorization,X-Api-Key");

	}
	public static void main(String aArgs[]) {
		System.out.println(Tutor4MeUtils.generateID("STD"));
	}
	
	
}
