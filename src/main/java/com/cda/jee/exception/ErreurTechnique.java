package com.cda.jee.exception;

public class ErreurTechnique extends RuntimeException {

	public ErreurTechnique(Exception e) {
		super(e);
	}

	private static final long serialVersionUID = 1L;

}
