package com.manzar.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AgeCalculatorTest {

  @Test
  void calculateReturnsZeroIfBirthDateIsNull() {
    assertEquals(0, AgeCalculator.calculate(null, LocalDate.now()));
  }

  @Test
  void calculateReturnsNegativeNumberIfBirthDateBeforeNow() {
    assertEquals(-1, AgeCalculator.calculate(LocalDate.now().plusYears(1), LocalDate.now()));
  }

  @ParameterizedTest
  @MethodSource("provideBirthDates")
  void calculateWorkingProperly(LocalDate birthDate, LocalDate now, int age) {
    assertEquals(age, AgeCalculator.calculate(birthDate, now));
  }

  private static Stream<Arguments> provideBirthDates() {
    return Stream.of(Arguments.of(LocalDate.of(2017, 12, 12),
            LocalDate.of(2022, 12, 12), 5),
        Arguments.of(LocalDate.of(2000, 10, 10), LocalDate.of(2020, 5, 7), 19),
        Arguments.of(LocalDate.of(1995, 2, 5), LocalDate.of(2022, 9, 3), 27));
  }
}