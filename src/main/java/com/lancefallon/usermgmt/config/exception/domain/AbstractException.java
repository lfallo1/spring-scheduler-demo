package com.lancefallon.usermgmt.config.exception.domain;

public abstract class AbstractException extends Exception{
	private static final long serialVersionUID = 1L;

	public abstract CustomErrorMessage getError();
}
