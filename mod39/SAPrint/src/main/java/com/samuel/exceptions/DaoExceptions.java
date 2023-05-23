package com.samuel.exceptions;

public class DaoExceptions extends Exception {
    
    public DaoExceptions(String msg, Exception ex) {
		super(msg, ex);
    }
}
