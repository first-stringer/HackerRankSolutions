import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/* 0014-HR: BIG SORTING */

class Result {

  static int compareStringNumbers(String num1, String num2) {
    if (num1.length() < num2.length()) return -1;
    if (num1.length() > num2.length()) return 1;

    for (int i = 0; i < num1.length(); i++) {
      if (num1.charAt(i) < num2.charAt(i)) return -1;
      if (num1.charAt(i) > num2.charAt(i)) return 1;
    }

    return 0;
  }

  static int partition(List<String> numbers, int low, int high) {
    String pivot = numbers.get(high);
    int i = (low - 1);

    for (int j = low; j < high; j++) {
      if (compareStringNumbers(numbers.get(j), pivot) <= 0) {
        i++;
        String temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
      }
    }

    String temp = numbers.get(i + 1);
    numbers.set(i + 1, numbers.get(high));
    numbers.set(high, temp);

    return (i + 1);
  }

  static void quickSort(List<String> numbers, int low, int high) {
    if (low < high) {
      int pi = partition(numbers, low, high);
      quickSort(numbers, low, pi - 1);
      quickSort(numbers, pi + 1, high);
    }
  }

  /*
   * Complete the 'bigSorting' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY unsorted as parameter.
   */
  public static List<String> bigSorting(List<String> unsorted) {
    // Write your code here
    Result.quickSort(unsorted, 0, unsorted.size() - 1);
    return unsorted;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        // new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> unsorted = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String unsortedItem = bufferedReader.readLine();
      unsorted.add(unsortedItem);
    }

    List<String> result = Result.bigSorting(unsorted);

    for (int i = 0; i < result.size(); i++) {
      bufferedWriter.write(result.get(i));

      if (i != result.size() - 1) {
        bufferedWriter.write("\n");
      }
    }

    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
