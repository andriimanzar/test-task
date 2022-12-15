package com.manzar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.manzar.UserFactory;
import com.manzar.exception.UserNotFoundException;
import com.manzar.model.User;
import com.manzar.repository.UserRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;


  @Test
  void getUserByIdWorkingProperly() {
    User testUser = UserFactory.createTestUser();
    when(userRepository.findById(anyLong()))
        .thenReturn(Optional.of(testUser));

    assertEquals(testUser, userService.getUserById(1L));
  }

  @Test
  void getUserByIdThrowsAnExceptionIfUserNotFound() {
    assertThrows(UserNotFoundException.class, () -> userService.getUserById(1L));
  }
}