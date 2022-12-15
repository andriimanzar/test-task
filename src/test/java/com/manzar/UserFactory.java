package com.manzar;

import com.manzar.model.User;

public class UserFactory {

  public static User createTestUser() {
    return new User(1L, "test", "test", 30);
  }

}
