package com.fdymendo.projecteuler.general;

import java.util.HashSet;
import java.util.Set;
import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0010 {
  public static void main(String[] args) {
    // The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

    // Find the sum of all the primes below two million.
    long startTime = System.currentTimeMillis();
    log.info("Find the sum of all the primes below: {}", findSumBelowOf(2000000));
    GenericMethods.differenceTime(startTime);
  }

  public static final String findSumBelowOf(int number) {
    Double result = 2.0;

    Set<Integer> noPrimos = new HashSet<>();
    Set<Integer> primos = new HashSet<>();
    for (int i = 3; i <= number; i += 2) {
      if (!noPrimos.contains(i)) {
        result += i;
        primos.add(i);
        for (int j = 1; (j * i) <= number; j++) {
          noPrimos.add(j * i);
        }
      }
    }
    return GenericMethods.PrintDouble(result);
  }

}
