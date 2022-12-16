package com.manzar.service.form;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserForm {

  private String firstName;
  private String lastName;
  private int age;

}
