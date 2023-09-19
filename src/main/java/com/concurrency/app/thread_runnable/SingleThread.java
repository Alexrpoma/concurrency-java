package com.concurrency.app.thread_runnable;

import java.util.List;
import java.util.stream.IntStream;

public class SingleThread extends Thread {
  private int size;
  private final List<Integer> list;
  private boolean printThreadStatus = false;

  public SingleThread(int size, List<Integer> list, boolean printThreadStatus) {
    this.size = size;
    this.list = list;
    this.printThreadStatus = printThreadStatus;
  }

  @Override
  public void run() {
    long start = System.currentTimeMillis();
    IntStream.range(0, size).forEach(i -> {
      list.add(i);
      if(printThreadStatus) System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
    });
    long end = System.currentTimeMillis();
    System.out.printf("Added %d elements to list in %dms\n", size, end - start);
  }
}
