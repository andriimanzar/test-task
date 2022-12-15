package com.manzar.controller;

import com.manzar.model.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  public User getUserById() {
    return new User();
  }

}
