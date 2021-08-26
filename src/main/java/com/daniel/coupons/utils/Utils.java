package com.daniel.coupons.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	public final static boolean isPhoneNumberValid(String phoneNumber) {
		String regex = "\\d{3}-\\d{3}\\d{4}"; // XXX-XXX-XXXX
		return phoneNumber.matches(regex);
	}

	public final static boolean isEmailValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public final static boolean isDateValid(String date) {

		String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();

	}
	
	private static final SecureRandom secureRandom = new SecureRandom(); 
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();
	
	public static String generateToken() {
	    
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
	
	public static byte[] hashPassword(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			String saltedValue = saltValue(password);
			return digest.digest(saltedValue.getBytes(StandardCharsets.UTF_8));
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
	
	private static String saltValue(String password) {


		String leftSalt = "!&DJsfamhk81248##9@(";
		String rightSalt = "@82fhls()2%%^(@nslG9f";

		return leftSalt + password + rightSalt;
	}

}




