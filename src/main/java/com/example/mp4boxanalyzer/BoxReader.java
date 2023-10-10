package com.example.mp4boxanalyzer;

import java.io.IOException;
import java.nio.ByteBuffer;

public class BoxReader {

  private final byte[] bytes;
  private int position;

  public BoxReader(byte[] bytes) {
    this.bytes = bytes;
    this.position = 0;
  }

  public Box readBox() throws IOException {
    int size = readInt();
    BoxType type;
    try {
      type = BoxType.valueOf(new String(readBytes()).toUpperCase());
    } catch (Exception e) {
      return null;
    }
    Box box = new Box(type, size);
    if (type == BoxType.MOOF || type == BoxType.TRAF) {
      for (int i = 0; i < size - 8; i += 8) {
        box.addSubBox(readBox());
      }
    }
    return box;
  }

  private int readInt() {
    return ByteBuffer.wrap(readBytes()).getInt();
  }

  private byte[] readBytes() {
    int length = 4;
    byte[] newBytes = new byte[length];
    System.arraycopy(this.bytes, this.position, newBytes, 0, length);
    this.position += length;
    return newBytes;
  }
}
