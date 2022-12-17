package com.manzar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

import com.manzar.exception.UserNotFoundException;
import com.manzar.model.User;
import com.manzar.repository.UserRepository;
import com.manzar.service.form.UserForm;
import com.manzar.util.AgeCalculator;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @Mock
  private UserRepository userRepository;

  @InjectMocks
  private UserService userService;


  @ParameterizedTest
  @MethodSource("provideUsersAndTheirAge")
  void getUserByIdWorkingProperly(User testUser) {
    when(userRepository.findById(anyLong()))
        .thenReturn(Optional.of(testUser));

    UserForm user = userService.getUserById(1L);

    assertEquals(testUser.getFirstName(), user.getFirstName());
    assertEquals(testUser.getLastName(), user.getLastName());
    assertEquals(AgeCalculator.calculate(testUser.getBirthDate(), LocalDate.now()), user.getAge());
  }

  @Test
  void getUserByIdThrowsAnExceptionIfUserNotFound() {
    assertThrows(UserNotFoundException.class, () -> userService.getUserById(1L));
  }

  private static Stream<Arguments> provideUsersAndTheirAge() {
    return Stream.of(
        Arguments.of(new User(1L, "test", "test", LocalDate.of(2000, 10, 10))),
        Arguments.of(new User(2L, "test", "test", LocalDate.of(2001, 5, 2))),
        Arguments.of(new User(3L, "test", "test", LocalDate.of(1990, 7, 3))));

  }
}