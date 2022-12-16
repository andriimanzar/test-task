package com.manzar;

import com.manzar.model.User;
import java.time.LocalDate;

public class UserFactory {

  public static User createTestUser() {
    return new User(1L, "test", "test", LocalDate.of(1995, 5, 15));
  }

}
