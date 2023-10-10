package com.example.mp4boxanalyzer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Box {
  private BoxType type;
  private long size;
  private List<Box> subBoxes;

  public Box(BoxType type, long size) {
    this.type = type;
    this.size = size;
    this.subBoxes = new ArrayList<>();
  }

  public void addSubBox(Box subBox) {
    if (subBox != null) {
      this.subBoxes.add(subBox);
    }
  }
}
