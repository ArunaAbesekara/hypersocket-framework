/*******************************************************************************
 * Copyright (c) 2013 Hypersocket Limited.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/
package com.hypersocket.session.json;

public class SessionTimeoutException extends Exception {

	private static final long serialVersionUID = -8997080206346696267L;

	public SessionTimeoutException() {
	}

	public SessionTimeoutException(String arg0) {
		super(arg0);
	}

	public SessionTimeoutException(Throwable arg0) {
		super(arg0);
	}

	public SessionTimeoutException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
