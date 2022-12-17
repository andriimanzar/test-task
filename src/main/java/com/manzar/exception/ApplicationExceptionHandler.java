package com.manzar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {

  private static final String USER_NOT_FOUND_ERROR_CODE = "user_not_found";

  @ExceptionHandler
  public ResponseEntity<ExceptionInfo> handleUserNotFoundException(UserNotFoundException e) {
    return new ResponseEntity<>(new ExceptionInfo(USER_NOT_FOUND_ERROR_CODE, e.getMessage()),
        HttpStatus.NOT_FOUND);
  }

  @Getter
  @Setter
  @AllArgsConstructor
  private static class ExceptionInfo {

    private final String errorCode;
    private final String errorMessage;
  }
}
