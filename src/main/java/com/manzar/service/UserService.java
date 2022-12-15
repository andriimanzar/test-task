package com.manzar.service;

import com.manzar.exception.UserNotFoundException;
import com.manzar.model.User;
import com.manzar.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User getUserById(Long id) {
    return userRepository.findById(id).orElseThrow(() ->
        new UserNotFoundException(String.format("User with id: %d not found", id)));
  }

}
