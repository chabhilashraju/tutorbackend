package com.tutor4me.uesr.util;

import java.util.Random;

public class Tutor4MeUtils {

	public static String generateID(String letter) {
		Random rnd = new Random();
		char[] digits = new char[7];
		digits[0] = (char) (rnd.nextInt(5) + '1');
		for (int i = 1; i < digits.length; i++) {
			digits[i] = (char) (rnd.nextInt(6) + '0');
		}
		return letter + new String(digits);
	}

	public static void main(String aArgs[]) {
		System.out.println(Tutor4MeUtils.generateID("STD"));
	}

}
