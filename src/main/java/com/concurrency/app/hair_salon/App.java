package com.concurrency.app.hair_salon;

public class App {
  public static void main(String[] args) {
    HairSalon hairSalon = new HairSalon();
    hairSalon.startThreads();
  }
}
