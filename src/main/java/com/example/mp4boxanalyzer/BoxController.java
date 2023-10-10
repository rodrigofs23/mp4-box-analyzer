package com.example.mp4boxanalyzer;

import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoxController {

  @GetMapping("/analyze")
  public List<Box> analyze(@RequestParam("url") String url) {
    // TODO: Implement this method.
    if (url == null) {
      throw new NullPointerException();
    }
    return Collections.emptyList();
  }
}
