package net.java8.part3.chapter11;

/**
 * Created by ciprian on 11/23/17.
 */

public class Util {

  public static void delay() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
