package com.curdoperation.exceptions;

import org.aspectj.bridge.AbortException;

public class ResourceNotFoundException extends AbortException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg) {
		supper(msg);
	}

	private void supper(String msg) {
		// TODO Auto-generated method stub
		
	}
}
