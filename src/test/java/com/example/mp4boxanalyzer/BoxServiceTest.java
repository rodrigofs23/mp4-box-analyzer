package com.example.mp4boxanalyzer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BoxServiceTest {

  @Mock private Mp4BoxAnalyzer mp4BoxAnalyzer;
  @InjectMocks private BoxService boxService;

  @Test
  void testAnalyze_withEmptyInput_returnsEmptyList() {
    var boxes = boxService.analyze("");
    assertEquals(0, boxes.size());
  }

  @Test
  void testAnalyze_withValidInput_returnsNonEmptyList() throws IOException {
    when(mp4BoxAnalyzer.analyzeMp4File(anyString())).thenReturn(List.of(new Box(BoxType.MDAT, 2)));
    var boxes = boxService.analyze("valid_url");
    assertEquals(1, boxes.size());
  }
}
