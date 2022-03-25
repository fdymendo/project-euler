package com.fdymendo.projecteuler.general;

import java.text.DecimalFormat;
import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0009 {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    log.info("Prime number is: {}", findSpecialPythagoreantriplet(1000));
    GenericMethods.differenceTime(startTime);
  }

  public static String findSpecialPythagoreantriplet(int number) {
    Double result = 0.0;
    boolean find = false;

    for (int a = 1; a < number - 1; a++) {
      for (int b = a + 1; b < number; b++) {

        Double tmpA = Math.pow(a, 2);
        Double tmpB = Math.pow(b, 2);
        Double tmpC = Math.sqrt(tmpA + tmpB);
        Double parteDecimal = tmpC % 1;
        Double parteEntera = tmpC - parteDecimal;
        if (parteDecimal == 0) {
          Double resultTmp = a + b + parteEntera;
          if (resultTmp == number) {
            result = a * b * parteEntera;
            find = true;
            break;
          }
        }

      }
      if (find) {
        break;
      }
    }
    DecimalFormat df = new DecimalFormat("#");
    df.setMaximumFractionDigits(8);

    return df.format(result);

  }

}
