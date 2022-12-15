package com.manzar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manzar.model.User;
import com.manzar.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class TestTaskEndToEndApplicationTests {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void getUserByIdWorkingProperly() throws Exception {
    User testUser = createUser();
    String resultJson = mockMvc.perform(MockMvcRequestBuilders.get("/api/users/1")).andExpect(
            status().isOk())
        .andReturn()
        .getResponse().getContentAsString();

    assertEquals(objectMapper.writeValueAsString(testUser), resultJson);
  }

  private User createUser() {
    return userRepository.save(UserFactory.createTestUser());
  }
}
