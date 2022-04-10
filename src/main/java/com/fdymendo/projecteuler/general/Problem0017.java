package com.fdymendo.projecteuler.general;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import com.fdymendo.projecteuler.util.ApplicationConstants;
import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0017 {

  public static void main(String[] args) {
    // If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3
    // + 3 + 5 + 4 + 4 = 19 letters used in total.
    //
    // If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how
    // many letters would be used?


    // NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains
    // 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when
    // writing out numbers is in compliance with British usage.
    String file = "/Project-euler-0017.txt";
    String pathEquivalence =
        ApplicationConstants.PATH_RESOURCES.concat(ApplicationConstants.PATH_PROJECT_EULER)
            .concat("/Project-euler-0017-equivalence.txt");
    String path = ApplicationConstants.PATH_RESOURCES
        .concat(ApplicationConstants.PATH_PROJECT_EULER).concat(file);
    String pathResource =
        ApplicationConstants.PATH_RESOURCES_VALUE.concat(ApplicationConstants.PATH_PROJECT_EULER);

    long startTime = System.currentTimeMillis();
    int numberMax = 1000;
    log.info("many letters would be used? {}",
        countLettersInWords(path, pathEquivalence, numberMax, pathResource, file));
    GenericMethods.differenceTime(startTime);

  }

  private static void generateNumbers(String pathEquivalencia, int number, String pathResource,
      String file) {
    HashMap<Integer, String> equivalence = getLoadEquivalence(pathEquivalencia);
    generateNumber(equivalence, number, pathResource, file);
  }

  private static void generateNumber(HashMap<Integer, String> equivalence, int number,
      String pathResource, String file) {
    ArrayList<String> numbers = new ArrayList<>();
    for (int i = 1; i <= number; i++) {
      if (equivalence.containsKey(i)) {
        numbers.add(i + ApplicationConstants.TEXT_SPACING + getText(equivalence, i));
      } else if (i < 100) {
        numbers
            .add(i + ApplicationConstants.TEXT_SPACING + getTexttwentyToNinetyNine(equivalence, i));
      } else if (i < 1001) {
        numbers.add(i + ApplicationConstants.TEXT_SPACING + getOneThousand(equivalence, i));

      }

    }
    GenericMethods.saveFile(numbers, pathResource, file);
  }

  private static String getText(HashMap<Integer, String> equivalence, int number) {
    return equivalence.get(number);
  }

  private static String getTexttwentyToNinetyNine(HashMap<Integer, String> equivalence,
      int number) {
    String tmp = number + "";
    String digit = getText(equivalence, Integer.parseInt(tmp.charAt(1) + ""));
    tmp = tmp.charAt(0) + ApplicationConstants.NUMBER_ZERO;
    String partInitial = getText(equivalence, Integer.parseInt(tmp));
    String result = partInitial + ApplicationConstants.TEXT_SPACING + digit;
    return result;
  }

  private static String getOneThousand(HashMap<Integer, String> equivalence, int number) {
    String tmp = number + "";
    String partInitial =
        tmp.charAt(0) + ApplicationConstants.NUMBER_ZERO + ApplicationConstants.NUMBER_ZERO;
    partInitial = getText(equivalence, Integer.parseInt(partInitial));
    String digits = tmp.charAt(1) + "" + tmp.charAt(2);
    int digitsTmp = Integer.parseInt(digits);
    if (equivalence.containsKey(digitsTmp)) {
      digits = getText(equivalence, digitsTmp);
    } else {
      digits = getTexttwentyToNinetyNine(equivalence, Integer.parseInt(digits));
    }
    String result = partInitial + ApplicationConstants.TEXT_SPACING + ApplicationConstants.TEXT_AND
        + ApplicationConstants.TEXT_SPACING + digits;
    return result;
  }

  private static HashMap<Integer, String> getLoadEquivalence(String path) {
    HashMap<Integer, String> equivalence = new HashMap<>();
    ArrayList<String> lines = loadLines(path);
    lines.stream().forEach(n -> {
      String[] tmp = n.split(ApplicationConstants.TEXT_SPACING);
      int value = Integer.parseInt(tmp[0]);
      equivalence.put(value, tmp[1]);
    });
    return equivalence;
  }

  private static int countLettersInWords(String path, String pathEquivalencia, int number,
      String pathResource, String file) {
    generateNumbers(pathEquivalencia, number, pathResource, file);
    int result = 0;
    ArrayList<String> lines = loadLines(path);
    for (String line : lines) {
      String[] lineSeparate = separateLine(line);
      for (int i = 1; i < lineSeparate.length; i++) {
        String tmp = lineSeparate[i];
        result += tmp.length();
      }
    }

    return result;
  }

  private static ArrayList<String> loadLines(String path) {
    ArrayList<String> lines = new ArrayList<>();
    File f;
    try {

      f = GenericMethods.loadFile(path);
      InputStream inputStream = GenericMethods.loadArchive(f);
      Scanner obj = new Scanner(inputStream);
      while (obj.hasNextLine()) {
        String tmp = obj.nextLine();
        lines.add(tmp);
      }
      obj.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return lines;
  }

  private static String[] separateLine(String line) {
    String[] tmp = line.replace("-", ApplicationConstants.TEXT_SPACING)
        .split(ApplicationConstants.TEXT_SPACING);
    return tmp;
  }
}
