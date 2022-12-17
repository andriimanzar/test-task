package com.manzar.service;

import com.manzar.exception.UserNotFoundException;
import com.manzar.model.User;
import com.manzar.repository.UserRepository;
import com.manzar.service.form.UserForm;
import com.manzar.util.AgeCalculator;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public UserForm getUserById(Long id) {
    User user = userRepository.findById(id).orElseThrow(() ->
        new UserNotFoundException(String.format("User with id: %d not found", id)));

    int userAge = AgeCalculator.calculate(user.getBirthDate(), LocalDate.now());

    return new UserForm(user.getFirstName(), user.getLastName(), userAge);
  }
}
