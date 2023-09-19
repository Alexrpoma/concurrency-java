package com.concurrency.app.thread_runnable;

import java.util.List;
import java.util.stream.IntStream;

public class MultiThread {
  private static List<Integer> list;
  private static int size;

  public MultiThread(int size, List<Integer> list) {
    this.list = list;
    this.size = size;
  }

  public void apply() throws InterruptedException {
    long start = System.currentTimeMillis();
    Thread threadA = new Thread(() ->
      IntStream.range(0, size).forEach(list::add)
    );
    Thread threadB = new Thread(() ->
      IntStream.range(0, size).forEach(list::add)
    );
    threadA.start();
    threadB.start();
    threadA.join(); // .join() -> Wait for the threads to finish their work
    threadB.join();
    long end = System.currentTimeMillis();
    System.out.printf("Added %d elements to list in %dms\n", list.size(), end - start);
  }
}
