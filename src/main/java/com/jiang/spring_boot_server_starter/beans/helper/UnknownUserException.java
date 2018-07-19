package com.jiang.spring_boot_server_starter.beans.helper;

public class UnknownUserException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5880139140307805889L;

	public UnknownUserException(String message) {
        super(message);
    }

}
