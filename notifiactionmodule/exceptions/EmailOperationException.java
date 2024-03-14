package com.newroztech.dizli.notifiactionmodule.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailOperationException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(EmailOperationException.class);

    public EmailOperationException(String message){
        super(message);
        logger.error("EmailOperationException: " + message);
    }
    public EmailOperationException(String message, Throwable cause){
        super(message,cause);
        logger.error("EmailOperationException: " + message, cause);
    }
}
