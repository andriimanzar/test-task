package com.manzar.controller;

import com.manzar.service.UserService;
import com.manzar.service.form.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/{id}")
  public UserForm getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

}
