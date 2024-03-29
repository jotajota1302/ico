package com.ntt.es.validation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidatorContext;

public class ValidationUtils {

	public static boolean isValidNifFormat(String value, String errorMessage, String propertyName,
			ConstraintValidatorContext context) {
		if (value == null || value.length() != 9 || !value.matches("[A-Za-z0-9]+")) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyName)
					.addConstraintViolation();
			return false;
		}
		return true;
	}

	public static boolean isValidString(String value, String errorMessage, String propertyName,
			ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyName)
					.addConstraintViolation();
			return false;
		}
		return true;
	}

	public static boolean isValidStringRegex(String value, String errorMessage, String propertyName,
			ConstraintValidatorContext context, String regex) {
		if (value == null || value.isEmpty() || !value.matches(regex)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyName)
					.addConstraintViolation();
			return false;
		}
		return true;
	}

	public static boolean isValidDigitsCommas(String value, String errorMessage, String propertyName,
			ConstraintValidatorContext context) {
		if (value == null || value.isEmpty() || !value.matches("[0-9,]+")) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyName)
					.addConstraintViolation();
			return false;
		}
		return true;
	}

	public static boolean isValidDigits(String value, String errorMessage, String propertyName,
			ConstraintValidatorContext context) {
		if (value == null || value.isEmpty() || !value.matches("[0-9]+")) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyName)
					.addConstraintViolation();
			return false;
		}
		return true;
	}

	public static boolean isValidDate(String value, String errorMessage, String propertyName,
			ConstraintValidatorContext context) {
		if (value == null || value.isEmpty()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyName)
					.addConstraintViolation();
			return false;
		}
		try {
			new SimpleDateFormat("dd-MM-yyyy").parse(value);
		} catch (ParseException e) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyName)
					.addConstraintViolation();
			return false;
		}
		return true;
	}

	public static boolean isValidLength(String value, int length, String errorMessage, String propertyName,
			ConstraintValidatorContext context) {

		if ((value.length() != length)) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyName)
					.addConstraintViolation();
			return false;
		}

		return true;
	}

	public static boolean isNotNullOrEmpty(String value, String errorMessage, String propertyName,
			ConstraintValidatorContext context) {

		if (value == null || value.isEmpty()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyName)
					.addConstraintViolation();
			return false;
		}

		return true;
	}

	public static boolean isNotNull(Object value, String errorMessage, String propertyName,
			ConstraintValidatorContext context) {
		if (value == null) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(errorMessage).addPropertyNode(propertyName)
					.addConstraintViolation();
			return false;
		}

		return true;
	}

}
