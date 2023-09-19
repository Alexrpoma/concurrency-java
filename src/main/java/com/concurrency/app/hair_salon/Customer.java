package com.concurrency.app.hair_salon;

public class Customer {
  private final String name;
  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
