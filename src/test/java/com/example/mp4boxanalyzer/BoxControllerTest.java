package com.example.mp4boxanalyzer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class BoxControllerTest {
  @Test
  void testAnalyze_withEmptyInput_returnsEmptyList() {
    BoxController boxController = new BoxController();
    List<Box> boxes = boxController.analyze("");
    assertEquals(0, boxes.size());
  }

  @Test
  void testAnalyze_withNullInput_throwsNullPointerException() {
    BoxController boxController = new BoxController();
    assertThrows(
        NullPointerException.class,
        () -> {
          List<Box> boxes = boxController.analyze(null);
        });
  }
}
