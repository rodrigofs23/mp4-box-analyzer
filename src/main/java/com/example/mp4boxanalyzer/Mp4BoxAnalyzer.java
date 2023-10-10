package com.example.mp4boxanalyzer;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Component
public class Mp4BoxAnalyzer {

  private final WebClient webClient;

  public Mp4BoxAnalyzer() {
    this.webClient = WebClient.builder().defaultHeader(ACCEPT, APPLICATION_JSON_VALUE).build();
  }

  public List<Box> analyzeMp4File(String url) throws IOException {
    ByteArrayResource byteArrayResource = getByteArrayResource(url);

    BoxReader boxReader = new BoxReader(getBytes(byteArrayResource));
    List<Box> boxes = new ArrayList<>();
    readBoxesRecursively(boxReader.readBox(), boxes);
    return boxes;
  }

  private ByteArrayResource getByteArrayResource(String url) {
    ByteArrayResource byteArrayResource;
    try {
      byteArrayResource =
          webClient.get().uri(url).retrieve().bodyToFlux(ByteArrayResource.class).blockFirst();
    } catch (Exception e) {
      throw new RuntimeException("Unable to fetch MP4 file from remote URL", e);
    }
    return byteArrayResource;
  }

  private static byte[] getBytes(ByteArrayResource byteArrayResource) {
    try {
      return getInputStream(byteArrayResource).readAllBytes();
    } catch (IOException e) {
      throw new RuntimeException("Unable to read bytes from ByteArrayResource", e);
    }
  }

  private static InputStream getInputStream(ByteArrayResource byteArrayResource) {
    try {
      return byteArrayResource.getInputStream();
    } catch (IOException e) {
      throw new RuntimeException("Unable to get input stream from ByteArrayResource", e);
    }
  }

  private static void readBoxesRecursively(Box box, List<Box> boxes) {
    if (box == null) {
      return;
    }
    boxes.add(box);
    if ((box.getType() == BoxType.MOOF || box.getType() == BoxType.TRAF)) {
      box.getSubBoxes().forEach(subBox -> readBoxesRecursively(subBox, boxes));
    }
  }
}
