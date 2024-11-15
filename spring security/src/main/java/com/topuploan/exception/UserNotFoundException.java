package com.topuploan.exception;

public class UserNotFoundException extends RuntimeException {
public UserNotFoundException(String value) {
	super(value);
}
}
