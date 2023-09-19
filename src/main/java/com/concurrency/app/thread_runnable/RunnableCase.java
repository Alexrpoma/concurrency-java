package com.concurrency.app.thread_runnable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RunnableCase implements Runnable {

  private static final int size = 5;
  private static final List<Integer> arrayList = new ArrayList<>();

  @Override
  public void run() {
    IntStream.range(0, size).forEach(i -> {
      arrayList.add(i);
      System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
    });
    System.out.println("Size " + arrayList.size());
  }
}
