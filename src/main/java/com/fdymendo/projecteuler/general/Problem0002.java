package com.fdymendo.projecteuler.general;

import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0002 {
  // Each new term in the Fibonacci sequence is generated by adding the
  // previous two terms. By starting with 1 and 2, the first 10 terms will be:
  //
  // 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
  //
  // By considering the terms in the Fibonacci sequence whose values do
  // not exceed four million, find the sum of the even- valued terms.
  //
  public static void main(String[] args) {

    int limit = 4000000;
    long startTime = System.currentTimeMillis();
    log.info("Sum of the even-valued terms: {}", generate(limit));
    GenericMethods.differenceTime(startTime);

  }

  private static int generate(int limit) {
    boolean limitExced = false;
    int elementA = 1;
    int elementB = 2;
    int total = elementB;

    while (!limitExced) {

      int tmp = sumFinochachi(elementA, elementB);
      elementA = elementB;
      elementB = tmp;
      if (GenericMethods.itsEven(tmp)) {
        total += tmp;
      }
      if (tmp >= limit) {
        limitExced = true;
      }
    }
    return total;
  }

  private static int sumFinochachi(int a, int b) {
    return a + b;
  }
  
}
