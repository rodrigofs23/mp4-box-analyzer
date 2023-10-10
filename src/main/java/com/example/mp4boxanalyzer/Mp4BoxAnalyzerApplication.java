package com.example.mp4boxanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Mp4BoxAnalyzerApplication {

  public static void main(String[] args) {
    SpringApplication.run(Mp4BoxAnalyzerApplication.class, args);
  }
}
