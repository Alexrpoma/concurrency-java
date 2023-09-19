package com.concurrency.app.thread_runnable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class App {
  public static void main(String[] args) throws InterruptedException {
    //singleThread();
    //multiThread();
    runnable();
  }

  public static void singleThread() {
    System.out.println("Single thread");
    SingleThread threadArrayList = new SingleThread(10000000, new ArrayList<>(), false);
    SingleThread threadVector = new SingleThread(10000000, new Vector<>(), false);

    threadArrayList.start(); // -> around 370ms
    threadVector.start(); // -> around 300ms
  }

  public static void multiThread() throws InterruptedException {
    System.out.println("MultiThread add 1000000 elements to a list for TWO threads");
    System.out.println("Result expected: 2000000");

    MultiThread multiThread = new MultiThread(1000000, new ArrayList<>());
    System.out.println("\nWhit ArrayList (Async):");
    multiThread.apply();

    System.out.println("\nWhit Vector (Sync):");
    MultiThread multiThreadVector = new MultiThread(1000000, new Vector<>());
    multiThreadVector.apply();

    System.out.println("\nWhit ArrayList (Apply Sync):");
    MultiThread multiThreadArrayListSync = new MultiThread(
        1000000, Collections.synchronizedList(new ArrayList<>()));
    multiThreadArrayListSync.apply();
  }

  public static void runnable() {
    RunnableCase runnableCaseA = new RunnableCase();
    RunnableCase runnableCaseB = new RunnableCase();

    Thread threadA = new Thread(runnableCaseA);
    Thread threadB = new Thread(runnableCaseB);
    threadA.start();
    threadB.start();
  }
}
