package com.fdymendo.projecteuler.util;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class GenericMethods {

  public static void differenceTime(long startTime) {
    log.info("Duración: {} milliseconds", System.currentTimeMillis() - startTime);
  }

  public static boolean itsEven(int number) {
    return (number % 2 == 0);
  }
}
