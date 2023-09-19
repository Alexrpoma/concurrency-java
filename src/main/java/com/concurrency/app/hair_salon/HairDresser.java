package com.concurrency.app.hair_salon;

import java.util.Random;

public class HairDresser implements Runnable {

  private final HairSalon hairSalon;
  private final String name;

  public HairDresser(HairSalon hairSalon, String name) {
    this.hairSalon = hairSalon;
    this.name = name;
  }

  @Override
  public void run() {
    Random random = new Random();
    try {
      while (true) {
        Customer customer = hairSalon.getCustomer();
        System.out.println(name + " is attending to " + customer.getName());
        int time = random.nextInt(10) + 1;
        Thread.sleep(time * 1000);
        System.out.println(name + " finished attend to " + customer.getName() + " in " + time);
      }
    } catch (InterruptedException e) {
        throw new RuntimeException(e.getCause());
    }
  }
}
