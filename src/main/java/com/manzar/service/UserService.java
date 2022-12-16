package com.manzar.service;

import com.manzar.exception.UserNotFoundException;
import com.manzar.model.User;
import com.manzar.repository.UserRepository;
import com.manzar.service.form.UserForm;
import java.time.LocalDate;
import java.time.Period;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserForm getUserById(Long id) {
    User user = userRepository.findById(id).orElseThrow(() ->
        new UserNotFoundException(String.format("User with id: %d not found", id)));

    int userAge = calculateAge(user.getBirthDate());

    return new UserForm(user.getFirstName(), user.getLastName(), userAge);
  }

  private int calculateAge(LocalDate birthDate) {
    if (birthDate != null) {
      return Period.between(birthDate, LocalDate.now()).getYears();
    } else {
      return 0;
    }
  }

}
