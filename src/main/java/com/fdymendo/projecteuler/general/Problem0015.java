package com.fdymendo.projecteuler.general;

import java.math.BigInteger;
import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0015 {
  public static void main(String[] args) {
    // Starting in the top left corner of a 2×2 grid, and only being able to move to the right and
    // down, there are exactly 6 routes to the bottom right corner.
    int position = 20;
    long startTime = System.currentTimeMillis();
    log.info("How many such routes are there through a 20×20 grid? {}", getLattice(position));
    GenericMethods.differenceTime(startTime);

  }

  public static String getLattice(int position) {
    BigInteger n = new BigInteger("" + (position + position));
    BigInteger k = new BigInteger("" + position);
    BigInteger up = getFactorial(n);
    BigInteger downFactorial = getFactorial(n.subtract(k));
    BigInteger down = downFactorial.multiply(getFactorial(k));
    String result = up.divide(down).toString();
    return result;

  }

  public static BigInteger getFactorial(BigInteger number) {
    if (number.equals(BigInteger.ZERO)) {
      return BigInteger.ONE;
    }
    BigInteger tmp = number;
    for (int i = 1; i < number.intValue(); i++) {
      tmp = tmp.multiply(new BigInteger("" + i));
    }
    return tmp;
  }

}
