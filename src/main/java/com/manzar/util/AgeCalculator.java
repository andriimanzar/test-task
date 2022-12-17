package com.manzar.util;

import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

  public static int calculate(LocalDate birthDate, LocalDate now) {
    if (birthDate != null) {
      return Period.between(birthDate, now).getYears();
    } else {
      return 0;
    }
  }
}
