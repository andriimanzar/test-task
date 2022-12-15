package com.manzar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExceptionInfo {

  private final String errorCode;
  private final String errorMessage;

}
