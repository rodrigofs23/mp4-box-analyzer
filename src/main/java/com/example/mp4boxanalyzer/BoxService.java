package com.example.mp4boxanalyzer;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BoxService {

  private final Mp4BoxAnalyzer mp4BoxAnalyzer;

  public BoxService(Mp4BoxAnalyzer mp4BoxAnalyzer) {
    this.mp4BoxAnalyzer = mp4BoxAnalyzer;
  }

  public List<Box> analyze(String url) {
    try {
      return mp4BoxAnalyzer.analyzeMp4File(url);
    } catch (Exception e) {
      log.error("Unable to analyze MP4 file", e);
      throw new RuntimeException("Unable to analyze MP4 file", e);
    }
  }
}
