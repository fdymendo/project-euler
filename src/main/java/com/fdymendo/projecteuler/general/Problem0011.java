package com.fdymendo.projecteuler.general;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import com.fdymendo.projecteuler.util.ApplicationConstants;
import com.fdymendo.projecteuler.util.GenericMethods;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Problem0011 {

  public static void main(String[] args) {
    String path = ApplicationConstants.PATH_RESOURCES
        .concat(ApplicationConstants.PATH_PROJECT_EULER).concat("/Project-euler-0011.txt");
    int numItems = 4;
    long startTime = System.currentTimeMillis();
    log.info(
        "What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?: {}",
        greatestProductOfFourAdjacentNumbers(path, numItems));
    GenericMethods.differenceTime(startTime);
  }

  public static int greatestProductOfFourAdjacentNumbers(String path, int numItems) {
    int result = 0;
    int[][] items = loadItems(path);
    for (int y = numItems - 1; y < items.length - numItems; y++) {
      for (int x = numItems - 1; x < items[y].length - numItems; x++) {
        int tmp = maxCrossDiagonal(items, x, y);
        if (tmp > result) {
          result = tmp;
        }
      }
    }
    return result;

  }

  private static final int maxCrossDiagonal(int[][] items, int x, int y) {
    int result = 0;
    int multiplierUp = items[y][x] * items[y - 1][x] * items[y - 2][x] * items[y - 3][x];
    result = multiplierUp;
    int multiplierDown = items[y][x] * items[y + 1][x] * items[y + 2][x] * items[y + 3][x];
    if (result < multiplierDown) {
      result = multiplierDown;
    }
    int multiplierLeft = items[y][x] * items[y][x - 1] * items[y][x - 2] * items[y][x - 3];
    if (result < multiplierLeft) {
      result = multiplierLeft;
    }
    int multiplierRight = items[y][x] * items[y][x + 1] * items[y][x + 2] * items[y][x + 3];
    if (result < multiplierRight) {
      result = multiplierRight;
    }
    int multiplierTopLeft =
        items[y][x] * items[y - 1][x - 1] * items[y - 2][x - 2] * items[y - 3][x - 3];
    if (result < multiplierTopLeft) {
      result = multiplierTopLeft;
    }
    int multiplierTopRight =
        items[y][x] * items[y - 1][x + 1] * items[y - 2][x + 2] * items[y - 3][x + 3];
    if (result < multiplierTopRight) {
      result = multiplierTopRight;
    }
    int multiplierBottomLeft =
        items[y][x] * items[y + 1][x - 1] * items[y + 2][x - 2] * items[y + 3][x - 3];
    if (result < multiplierBottomLeft) {
      result = multiplierBottomLeft;
    }
    int multiplierBottomRight =
        items[y][x] * items[y + 1][x + 1] * items[y + 2][x + 2] * items[y + 3][x + 3];
    if (result < multiplierBottomRight) {
      result = multiplierBottomRight;
    }

    return result;
  }

  private static final int[][] loadItems(String path) {
    ArrayList<ArrayList<Integer>> matrizOfItems = new ArrayList<>();

    File f;
    try {

      f = GenericMethods.loadFile(path);
      InputStream inputStream = GenericMethods.loadArchive(f);
      Scanner obj = new Scanner(inputStream);
      while (obj.hasNextLine()) {
        String tmp = obj.nextLine();
        matrizOfItems.add(createFileItems(tmp));
      }
      obj.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    int width = matrizOfItems.get(0).size();
    int height = matrizOfItems.size();
    int[][] items = new int[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        items[j][i] = matrizOfItems.get(j).get(i);
      }
    }
    return items;
  }

  private static final ArrayList<Integer> createFileItems(String items) {
    ArrayList<Integer> listItems = new ArrayList<>();
    String[] itemsSplit = items.split(" ");
    for (String tmp : itemsSplit) {
      listItems.add(Integer.valueOf(tmp));
    }
    return listItems;
  }
}
