package com.codefulcrum.assessment.exception;

import com.codefulcrum.assessment.dto.ApiResponse;
import com.codefulcrum.assessment.dto.ProductResponseDTO;
import com.codefulcrum.assessment.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandling {

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<ApiResponse<ExceptionDetails>>  handleValidationExceptions(MethodArgumentNotValidException exception, WebRequest webRequest) {
       Map<String, String> errors = new HashMap<>();
       exception.getBindingResult().getAllErrors().forEach((error) -> {
           String fieldName = ((FieldError) error).getField();
           String errorMessage = error.getDefaultMessage();
           errors.put(fieldName, errorMessage);
       });
       log.error("MethodArgumentNotValidException : " + exception.getMessage());
       return new ResponseEntity<>(new ApiResponse<>(Constants.STATUS_CODE_FAILURE, Constants.STATUS_FAILURE_MESSAGE,
               new ExceptionDetails(new Date(), errors, webRequest.getDescription(true))), HttpStatus.BAD_REQUEST);
   }
    @ExceptionHandler(MysqlDataTruncation.class)
    public ResponseEntity<ApiResponse<ExceptionDetails>>  handleValidationExceptions(MysqlDataTruncation exception, WebRequest webRequest) {
        log.error("MysqlDataTruncation : " + exception.getMessage());
        exception.printStackTrace();
        return new ResponseEntity<>(new ApiResponse<>(Constants.STATUS_CODE_FAILURE, Constants.STATUS_FAILURE_MESSAGE,
                new ExceptionDetails(new Date(), Constants.INVALID_INFORMATION_PROVIDED, webRequest.getDescription(true))), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<ApiResponse<ExceptionDetails>>  handleValidationExceptions(JsonProcessingException exception, WebRequest webRequest) {
        log.error("JsonProcessingException : " + exception.getMessage());
        exception.printStackTrace();
        return new ResponseEntity<>(new ApiResponse<>(Constants.STATUS_CODE_FAILURE, Constants.STATUS_FAILURE_MESSAGE,
                new ExceptionDetails(new Date(), Constants.INVALID_INFORMATION_PROVIDED, webRequest.getDescription(true))), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ApiResponse<ExceptionDetails>>  handleValidationExceptions(EmptyResultDataAccessException exception, WebRequest webRequest) {
        log.error("EmptyResultDataAccessException : " + exception.getMessage());
        return new ResponseEntity<>(new ApiResponse<>(Constants.STATUS_CODE_FAILURE, Constants.STATUS_FAILURE_MESSAGE,
                new ExceptionDetails(new Date(), Constants.INVALID_ID, webRequest.getDescription(true))), HttpStatus.NOT_FOUND);
    }
}
