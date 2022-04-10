package com.fdymendo.projecteuler.general;

import java.math.BigInteger;
import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0016 {

  public static void main(String[] args) {
    // 21^5 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
    //
    // What is the sum of the digits of the number 2^1000?
    int number = 1000;
    long startTime = System.currentTimeMillis();
    log.info("What is the sum of the digits of the number 2^1000: {}", sumOfDigits(number));
    GenericMethods.differenceTime(startTime);
  }

  public static int sumOfDigits(int number) {
    BigInteger result = BigInteger.TWO;
    BigInteger tmp = BigInteger.TWO;

    for (int i = 1; i < number; i++) {
      result = result.multiply(tmp);
    }

    return sumValues(result.toString());
  }

  public static int sumValues(String number) {
    int result = 0;

    for (int i = 0; i < number.length(); i++) {
      result += Integer.parseInt(number.charAt(i) + "");
    }

    return result;

  }

}
