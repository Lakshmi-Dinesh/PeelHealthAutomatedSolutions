package com.algoma.exceptions;

public class IncorrectBrowserNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IncorrectBrowserNameException(String message) {
		super(message);
	}
}
