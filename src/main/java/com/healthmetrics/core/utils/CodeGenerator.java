package com.healthmetrics.core.utils;

import java.util.Random;

/**
 * Class used for generating keys.
 * 
 * @author Gloin
 * 
 */
public abstract class CodeGenerator {

	/** Base length of the code. */
	private static final Integer CODE_LENGTH = 42;

	/**
	 * Private constructor to avoid instantiation.
	 */
	private CodeGenerator() {

	}

	/**
	 * Generates a code.
	 * 
	 * @return The generated key.
	 */
	public static String generateCode() {
		String result = "";
		Random generator = new Random();
		String alphabet = "01234567890123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < CODE_LENGTH; i++) {
			result = result + alphabet.charAt(generator.nextInt(alphabet.length() - 1));
		}

		return result;
	}

	/**
	 * Returns the extra content that might have been appended to a code.
	 * 
	 * @param code
	 *            Code to parse.
	 * 
	 * @return A String with the extra content.
	 */
	public static String getExtraContentFromCode(String code) {
		return code.substring(CODE_LENGTH, code.length());
	}

	/**
	 * Returns the extra content that might have been appended to a code.
	 * 
	 * @param code
	 *            Code to parse.
	 * 
	 * @return A String with the extra content.
	 */
	public static String getCodeWithoutExtraContent(String code) {
		return code.substring(0, CODE_LENGTH);
	}
}
