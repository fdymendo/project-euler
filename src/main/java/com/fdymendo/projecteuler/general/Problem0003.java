package com.fdymendo.projecteuler.general;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0003 {


  // The prime factors of 13195 are 5, 7, 13 and 29.
  //
  // What is the largest prime factor of the number 600851475143 ?
  public static void main(String[] args) {
    long number = 600851475143L;
    log.info("largest prime factor of the number 600851475143: {}", largestPrimeFactor(number));
  }

  private static long largestPrimeFactor(long number) {

    boolean find = false;
    long maxValue = number / 3;
    if (maxValue % 2 == 0) {
      maxValue += 1;
    }
    while (!find) {
      log.info("maxvalue: {}", maxValue);
      if (isPrimeFactor(maxValue)) {
        log.info("encontro primo {}", maxValue);
        if (number % maxValue == 0) {
          find = true;
          return maxValue;
        }

      }
      maxValue -= 2;
    }
    log.info("salio");
    return 0;
  }

  private static boolean isPrimeFactor(long number) {
    if (number < 4) {
      log.info("true inicial");
      return true;
    }
    long maxValue = number / 3;
    if (maxValue % 2 == 0) {
      maxValue += 1;
    }
    log.info("max Value isPrimeFactor, {}", maxValue);
    for (int i = 2; i <= maxValue; i++) {
      if (number % i == 0) {
        log.info("encontro exacto");
        return false;
      }
//      log.info("ciclo {}", i);
    }
    log.info("true final");

    return true;
  }

}
