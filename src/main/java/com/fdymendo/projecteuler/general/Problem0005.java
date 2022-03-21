package com.fdymendo.projecteuler.general;

import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0005 {
  public static void main(String[] args) {
    // 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without
    // any remainder.
    // What is the smallest positive number that is evenly divisible by all of the numbers from 1 to
    // 20?
    long startTime = System.currentTimeMillis();
    log.info("Numero mas pequeño: {}", smallestPositiveNumber(20));
    GenericMethods.differenceTime(startTime);
    startTime = System.currentTimeMillis();
    log.info("Numero mas pequeño: {}", smallestPositiveNumberV2(20));
    GenericMethods.differenceTime(startTime);


  }

  public static int smallestPositiveNumber(int number) {
    int smallestNumber = number + 1;
    boolean find = false;
    do {
      boolean valid = true;
      for (int j = 1; j < number; j++) {

        if (!(smallestNumber % j == 0)) {
          valid = false;
          break;
        }
      }
      // log.info("marquer: {}", smallestNumber);
      if (valid) {
        find = true;
      }else {
        smallestNumber += 1;

      }
    } while (!find);

    return smallestNumber;
  }

  public static int smallestPositiveNumberV2(int number) {
    int smallestNumber = 0;
    int multiplier = 1;
    boolean find = false;
    do {
      boolean valid = true;
      int tmp = number * multiplier;
      // log.info("multiplicador: {}", tmp);
      for (int i = 1; i < number; i++) {
        // log.info("divisor: {}", tmp % i == 0);
        if (!(tmp % i == 0)) {
          valid = false;
          break;
        }
      }
      if (valid) {
        find = true;
        smallestNumber = tmp;
      }
      multiplier += 1;
    } while (!find);

    return smallestNumber;
  }
}
