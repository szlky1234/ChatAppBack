package com.szlky.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UncaughtExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(UncaughtExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public void handleUncaughtException(Exception ex) {

        try {
            throw ex;
        } catch (Exception e) {
            log.debug("unhandled exception {}", e.getMessage(), e);
        }

    }

}