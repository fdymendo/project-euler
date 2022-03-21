package com.fdymendo.projecteuler.general;

import java.util.HashMap;
import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0004 {

  public static void main(String[] args) {
    // A palindromic number reads the same both ways. The largest palindrome made from the product
    // of two 2-digit numbers is 9009 = 91 × 99.
    // Find the largest palindrome made from the product of two 3-digit numbers.
    long startTime = System.currentTimeMillis();
    log.info("es palindromo: {}", getMaxPalindrome(3));
    GenericMethods.differenceTime(startTime);

  }

  public static int getMaxPalindrome(int number) {
    int maxPalindrome = 0;
    HashMap<Integer, HashMap<Integer, Integer>> values = new HashMap<>();
    String num = "";
    for (int i = 0; i < number; i++) {
      num += "9";
    }
    int maxValue = Integer.valueOf(num);

    // rellenar
    for (int i = 1; i <= maxValue; i++) {
      values.put(i, new HashMap<>());
    }
    for (int i = 1; i <= maxValue; i++) {
      HashMap<Integer, Integer> tmpHash = values.get(i);
      for (int j = 1; j <= maxValue; j++) {
        if (!tmpHash.containsKey(j)) {
          tmpHash.put(j, j);
          if (isPalindrome(i * j)) {
            if (i * j > maxPalindrome) {
              maxPalindrome = i * j;
            }
          }
        }
      }
    }
    return maxPalindrome;
  }

  public static boolean isPalindrome(int number) {
    String tmp = String.valueOf(number);
    int tmpLength = tmp.length();

    boolean isPar = tmpLength % 2 == 0 ? true : false;
    int sizePart = tmpLength / 2;
    String part1 = tmp.substring(0, sizePart);
    String part2 = "";
    if (isPar) {
      part2 = tmp.substring(sizePart, tmpLength);
    } else {
      part2 = tmp.substring(sizePart + 1, tmpLength);
    }
    return part1.equals(reverse(part2));
  }

  public static String reverse(String text) {
    String tmp = "";
    for (int i = text.length() - 1; i > -1; i--) {
      tmp += text.charAt(i);
    }
    return tmp;
  }
}
