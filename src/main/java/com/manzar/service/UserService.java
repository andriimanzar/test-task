package com.manzar.service;

import com.manzar.exception.UserNotFoundException;
import com.manzar.model.User;
import com.manzar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUserById(Long id) {
    return userRepository.findById(id).orElseThrow(() ->
        new UserNotFoundException(String.format("User with id: %d not found", id)));
  }

}
