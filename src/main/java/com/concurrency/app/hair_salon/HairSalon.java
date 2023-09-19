package com.concurrency.app.hair_salon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class HairSalon {
  private static final int HAIRDRESSERS = 5;
  private static final int CUSTOMERS = 12;
  private Queue<Customer> customerQueue = new LinkedList<>();
  Object lock = new Object();
  private Thread[] hairdressersList;

  public HairSalon() {
    hairdressersList = new Thread[HAIRDRESSERS];
    IntStream.range(0, HAIRDRESSERS).forEach(i -> {
      hairdressersList[i] = new Thread(new HairDresser(this, "Hairdresser" + i));
    });
  }

  public void startThreads() {
    for (Thread hairdresser : hairdressersList) {
      hairdresser.start();
    }
    IntStream.range(0, CUSTOMERS).forEach(i -> {
      Customer customer = new Customer("Customer" + i);
      addCustomer(customer);
    });
  }

  public void addCustomer(Customer customer) {
    synchronized (lock) {
      customerQueue.offer(customer);
      lock.notify();
    }
  }
  public Customer getCustomer() throws InterruptedException {
    synchronized (lock) {
      while (customerQueue.isEmpty()) {
        lock.wait();
      }
      return customerQueue.poll();
    }
  }
}
