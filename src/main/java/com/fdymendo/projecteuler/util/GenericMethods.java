package com.fdymendo.projecteuler.util;

import java.text.DecimalFormat;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class GenericMethods {

  public static void differenceTime(long startTime) {
    log.info("Duración: {} milliseconds", System.currentTimeMillis() - startTime);
  }

  public static boolean itsEven(int number) {
    return (number % 2 == 0);
  }

  public static boolean isPrime(int number) {
    if (itsEven(number)) {
      if (number == 2) {
        return true;
      }
      return false;
    } else if (number > 8) {
      int numberMax = number / 3;
      for (int i = 3; i <= numberMax; i++) {
        if (number % i == 0) {
          return false;
        }
      }
    }
    return true;
  }

  public static String PrintDouble(Double number) {
    DecimalFormat df = new DecimalFormat("#");
    df.setMaximumFractionDigits(8);
    return df.format(number);
  }
}
