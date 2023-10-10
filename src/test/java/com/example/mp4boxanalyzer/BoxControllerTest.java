package com.example.mp4boxanalyzer;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class BoxControllerTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private BoxService BoxService;
  @InjectMocks private BoxController boxController;

  @Test
  void testAnalyze_withInvalidEndpoint_returnsNotFound() throws Exception {
    mockMvc.perform(get("/mp4boxanalyzer")).andExpect(status().isNotFound());
  }

  @Test
  void testAnalyze_withInvalidRequest_returnsBadRequest() throws Exception {
    mockMvc.perform(get("/api/v1/mp4boxanalyzer")).andExpect(status().isBadRequest());
  }

  @Test
  void testAnalyze_withValidEndpoint_returnsOk() throws Exception {
    mockMvc
        .perform(get("/api/v1/mp4boxanalyzer").param("url", "valid_url"))
        .andExpect(status().isOk());
  }
}
