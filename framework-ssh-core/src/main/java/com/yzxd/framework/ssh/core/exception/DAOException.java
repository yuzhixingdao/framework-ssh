package com.yzxd.framework.ssh.core.exception;

public class DAOException extends BaseException {

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(String msg, Throwable ex) {
		super(msg, ex);
	}

}
