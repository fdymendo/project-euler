package com.fdymendo.projecteuler.problem0001;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem001 {
  
  // If we list all the natural numbers below 10 that are multiples of 3 or 5,
  // we get 3, 5, 6 and 9. The sum of these multiples is 23.
  //
  // Find the sum of all the multiples of 3 or 5 below 1000.
  public static void main(String[] args) {
    // variables of problem
    List<Integer> multiplesOf = List.of(3, 5);
    int limit = 1000;
    long startTime = System.currentTimeMillis();
    int result = multiplesNumbersBelow(multiplesOf, limit);
    GenericMethods.differenceTime(startTime);
    log.info("Find the sum of all the multiples of 3 or 5 below 1000. Result: {}", result);

  }

  private static int multiplesNumbersBelow(List<Integer> multiplesOf, int limit) {
    HashMap<Integer, Integer> collect = new HashMap<>();

    for (int MultipleOf : multiplesOf) {
      int multiplier = 1;
      for (int tmp = 0; tmp < limit;) {

        tmp = multiplier * MultipleOf;
        if (!collect.containsKey(tmp) && tmp < limit) {
          collect.put(tmp, tmp);
        }
        multiplier += 1;
      }
      multiplier = 1;
    }
    return sumValues(collect);
  }

  private static int sumValues(HashMap<Integer, Integer> collect) {
    int total = 0;
    for (Entry<Integer, Integer> item : collect.entrySet()) {
      total += item.getKey();
    }
    return total;

  }

}
