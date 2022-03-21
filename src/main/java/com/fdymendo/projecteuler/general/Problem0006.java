package com.fdymendo.projecteuler.general;

import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0006 {
  public static void main(String[] args) {
    // The sum of the squares of the first ten natural numbers is,

    // The square of the sum of the first ten natural numbers is,

    // Hence the difference between the sum of the squares of the first ten natural numbers and the
    // square of the sum is .

    // Find the difference between the sum of the squares of the first one hundred natural numbers
    // and the square of the sum.
    long startTime = System.currentTimeMillis();
    log.info(" difference between the sum of the squares: {}", getResult(100));
    GenericMethods.differenceTime(startTime);

  }

  private static int getResult(int number) {
    int squareOfSum = getSumOfSquare(number);
    int sumOfSquare = getSquareOfSum(number);
    return sumOfSquare - squareOfSum;
  }

  private static int getSumOfSquare(int number) {
    int squareSum = 0;
    for (int i = 1; i <= number; i++) {
      squareSum += i * i;
    }
    return squareSum;
  }

  private static int getSquareOfSum(int number) {
    int sumSquare = 0;
    for (int i = 1; i <= number; i++) {
      sumSquare += i;
    }

    return sumSquare * sumSquare;
  }

}
