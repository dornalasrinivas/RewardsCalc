package com.org.sales.controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(HttpServerErrorException.class)
	public void handleHttpServerErrorException(HttpServerErrorException ex, HttpServletResponse res)
			throws IOException {
		res.sendError(ex.getStatusCode().value(), ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public void handleException(Exception ex, HttpServletResponse res) throws IOException {
		log.error("Handled Internal Error Exception", ex);
		res.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Something went wrong");
	}
}
