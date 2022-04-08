package com.fdymendo.projecteuler.general;

import java.util.HashMap;
import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0014 {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    log.info("Which starting number, under one million, produces the longest chain?: {}",
        aboveOneMillion(1000000));
    GenericMethods.differenceTime(startTime);
    startTime = System.currentTimeMillis();
    log.info("Which starting number, under one million, produces the longest chain?: {}",
        aboveOneMillionV2(1000000));
    GenericMethods.differenceTime(startTime);
  }

  public static String aboveOneMillion(int number) {
    double result = 0;
    double sequence = 0;
    for (int i = 2; i < number; i++) {
      boolean completed = false;
      double resultTmp = i;
      int sequenceTmp = 0;

      do {
        if (GenericMethods.itsEven(resultTmp)) {
          resultTmp = functionEven(resultTmp);
        } else {
          resultTmp = functionNotEven(resultTmp);
        }
        sequenceTmp++;
        if (resultTmp == 1) {
          if (sequenceTmp >= sequence) {
            result = i;
            sequence = sequenceTmp;
          }
          completed = true;

        }
      } while (!completed);
    }
    return GenericMethods.PrintDouble(result);
  }

  public static String aboveOneMillionV2(int number) {
    double result = 0;
    double sequence = 0;

    HashMap<Double, Double> now = new HashMap<>();

    for (double i = 2; i < number; i++) {
      boolean completed = false;
      double resultTmp = i;
      double sequenceTmp = 0;

      do {

        if (now.containsKey(resultTmp)) {
          sequenceTmp += now.get(resultTmp);
          resultTmp = 1;
        } else if (GenericMethods.itsEven(resultTmp)) {

          resultTmp = functionEven(resultTmp);

        } else {

          resultTmp = functionNotEven(resultTmp);

        }
        sequenceTmp++;
        if (resultTmp == 1) {
          now.put(i, sequenceTmp);
          if (sequenceTmp >= sequence) {
            result = i;
            sequence = sequenceTmp;
          }
          completed = true;

        }
      } while (!completed);
    }
    return GenericMethods.PrintDouble(result);
  }

  public static double functionEven(double number) {
    return number / 2;
  }

  public static double functionNotEven(double number) {
    return (3 * number) + 1;
  }

}
