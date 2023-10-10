package com.example.mp4boxanalyzer;

import java.util.Collections;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mp4boxanalyzer")
public class BoxController {

  private final BoxService boxService;

  public BoxController(BoxService boxService) {
    this.boxService = boxService;
  }

  @GetMapping()
  public ResponseEntity<List<Box>> analyze(@RequestParam("url") String url) {
    try {
      return ResponseEntity.ok(boxService.analyze(url));
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(Collections.emptyList());
    }
  }
}
