package com.fdymendo.projecteuler.general;

import java.util.HashMap;
import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0012 {
  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();
    log.info("Value of the first triangle number: {}", firstDivisorsV2(500));
    GenericMethods.differenceTime(startTime);

  }

  public static int firstDivisors(int number) {
    int numberTriangle = 1;
    int triangle = 0;
    boolean find = false;
    do {
      triangle = sevenTriangule(numberTriangle);
      int divisors = countDivisors(triangle);
      if (divisors >= number) {
        find = true;
      }
      numberTriangle++;
    } while (!find);
    return triangle;

  }

  public static int firstDivisorsV2(int number) {
    int numberTriangle = 1;
    int triangle = 0;
    boolean find = false;
    do {
      triangle = sevenTriangule(numberTriangle);
      int divisors = countDivisorsV2(triangle);
      if (divisors >= number) {
        find = true;
      }
      numberTriangle++;
    } while (!find);
    return triangle;

  }

  public static int sevenTriangule(int number) {
    return (number * (number + 1)) / 2;
  }

  public static int countDivisors(int number) {
    int count = 2;
    for (int i = 2; i <= number / 2; i++) {
      if (number % i == 0) {
        count++;
      }
    }
    return count;
  }

  public static int countDivisorsV2(int number) {
    int maxValue = number / 2;
    int count = 2;
    HashMap<Integer, Integer> list = new HashMap<>();

    for (int i = 2; i <= maxValue; i++) {
      if (!list.containsKey(i)) {
        if (number % i == 0) {
          maxValue = number / i;
          if (number % maxValue == 0) {
            list.put(maxValue, maxValue);
            count++;
          }
          count++;
          list.put(i, i);
        }
      }
    }
    return count;
  }
}
