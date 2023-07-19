package com.algoma.exceptions;

public class IncorrectPageNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IncorrectPageNameException(String message) {
		super(message);
	}
}
