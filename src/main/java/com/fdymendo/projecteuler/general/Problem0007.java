package com.fdymendo.projecteuler.general;

import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0007 {

  public static void main(String[] args) {
    // By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime
    // is 13.

    // What is the 10 001st prime number?
    long startTime = System.currentTimeMillis();

    log.info("Prime number is: {}", getPrimeNumber(10001));
    GenericMethods.differenceTime(startTime);
    startTime = System.currentTimeMillis();
    log.info("Prime number is: {}", getPrimeNumberV2(10001));
    GenericMethods.differenceTime(startTime);


  }

  private static int getPrimeNumber(int number) {
    int primeNumber = 0;
    int numberOfPrime = 0;
    int tmpNumber = 2;
    do {
      // log.info("number actual: {}", tmpNumber);
      if (isPrimeNumber(tmpNumber)) {
        numberOfPrime += 1;
        primeNumber = tmpNumber;
      }
      tmpNumber += 1;
    } while (!(numberOfPrime == number));

    return primeNumber;
  }

  private static boolean isPrimeNumber(int number) {
    for (int i = 2; i < number; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    // log.info("Is prime: {}", number);
    return true;
  }

  private static int getPrimeNumberV2(int number) {
    int primeNumber = 0;
    int numberOfPrime = 0;
    int tmpNumber = 2;
    do {
      // log.info("number actual: {}", tmpNumber);
      if (GenericMethods.isPrime(tmpNumber)) {
        numberOfPrime += 1;
        primeNumber = tmpNumber;
      }
      tmpNumber += 1;
    } while (!(numberOfPrime == number));

    return primeNumber;
  }
}
