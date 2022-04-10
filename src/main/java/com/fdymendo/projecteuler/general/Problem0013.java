package com.fdymendo.projecteuler.general;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import com.fdymendo.projecteuler.util.ApplicationConstants;
import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0013 {
  public static void main(String[] args) {
    String path = ApplicationConstants.PATH_RESOURCES
        .concat(ApplicationConstants.PATH_PROJECT_EULER).concat("/Project-euler-0013.txt");
    long startTime = System.currentTimeMillis();
    log.info(
        "Work out the first ten digits of the sum of the following one-hundred 50-digit numbers: {}",
        tenDigits(path, 10));
    GenericMethods.differenceTime(startTime);
  }

  private static String tenDigits(String path, int number) {
    ArrayList<String> numbers = loadFile(path);
    if (numbers.size() < 1) {
      return "";
    }
    BigInteger total = BigInteger.ZERO;
    for (String tmp : numbers) {
      total = total.add(new BigInteger(tmp));
    }
    return total.toString();
  }

  private static ArrayList<String> loadFile(String path) {
    ArrayList<String> numbers = new ArrayList<>();
    File f;
    try {

      f = GenericMethods.loadFile(path);
      InputStream inputStream = GenericMethods.loadArchive(f);
      Scanner obj = new Scanner(inputStream);
      while (obj.hasNextLine()) {
        String tmp = obj.nextLine();
        numbers.add(tmp);
      }
      obj.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return numbers;

  }
  
}
