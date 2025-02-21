package com.sb.mybatis.postgre.web;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.sb.mybatis.postgre.dto.ErrorDTO;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler
{
    //Exception handling defined only for HTTP 400 scenarios, handling for other conditions to be
    //handled by Spring Boot (default) mechanism

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO handlemethodArgumentNotValid(MethodArgumentNotValidException e) {
        log.debug("GlobalExceptionHandler: MethodArgumentNotValidException - " + e.getMessage());
        log.info("GlobalExceptionHandler: MethodArgumentNotValidException - " + e.getMessage());

        List<String> invalidFields = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(FieldError::getField)
                .collect(Collectors.toList());
        return new ErrorDTO("Invalid or missing data for input field(s)", invalidFields);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorDTO handleConstraintViolation(ConstraintViolationException e) {
        log.debug("GlobalExceptionHandler: ConstraintViolationException - " + e.getMessage());
        log.info("GlobalExceptionHandler: ConstraintViolationException - " + e.getMessage());

        List<String> invalidFields = e.getConstraintViolations()
                .stream()
                .map(cv -> cv.getPropertyPath().toString())
                .collect(Collectors.toList());
        return new ErrorDTO("Constraint violated for input field(s)", invalidFields);
    }
}