package com.acortes.utils.core;

public class StringUtils {
	public static boolean isNullEmpty(String s) {
		if (s == null || s.isEmpty())
			return true;
		return false;
	}
}
