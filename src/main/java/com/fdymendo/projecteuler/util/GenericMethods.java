package com.fdymendo.projecteuler.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.springframework.util.ResourceUtils;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class GenericMethods {

  public static void differenceTime(long startTime) {
    log.info("Duración: {} milliseconds", System.currentTimeMillis() - startTime);
  }

  public static boolean itsEven(int number) {
    return (number % 2 == 0);
  }

  public static boolean itsEven(double number) {
    return (number % 2 == 0);
  }

  public static boolean isPrime(int number) {
    if (itsEven(number)) {
      if (number == 2) {
        return true;
      }
      return false;
    } else if (number > 8) {
      int numberMax = number / 3;
      for (int i = 3; i <= numberMax; i++) {
        if (number % i == 0) {
          return false;
        }
      }
    }
    return true;
  }

  public static String PrintDouble(Double number) {
    DecimalFormat df = new DecimalFormat("#");
    df.setMaximumFractionDigits(8);
    return df.format(number);
  }

  public static File loadFile(String path) throws FileNotFoundException {
    return ResourceUtils.getFile(path);
  }

  public static InputStream loadArchive(File f) throws FileNotFoundException {
    return new FileInputStream(f);
  }

  public static void saveFile(ArrayList<String> list, String savePath, String fileName) {
    try {

      File sf = new File(savePath);
      if (!sf.exists()) {
        sf.mkdirs();
      }
      FileOutputStream fos = new FileOutputStream(sf.getPath() + "/" + fileName);
      OutputStreamWriter osw = new OutputStreamWriter(fos);
      Writer writer = new BufferedWriter(osw);
      for (String s : list) {
        writer.write(s + "\n");
      }
      writer.flush();
      writer.close();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
