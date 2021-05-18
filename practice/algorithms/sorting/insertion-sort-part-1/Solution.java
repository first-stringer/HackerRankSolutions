import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/* 0015-HR: INSERTION SORT – PART 1 */

class Result {

  /*
   * Complete the 'insertionSort1' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY arr
   */
  public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
    int temp = arr.get(n - 1);
    int i;
    for (i = n - 1; i > 0; i--) {
      if (arr.get(i - 1) > temp) {
        arr.set(i, arr.get(i - 1));
        for (Integer itp : arr) System.out.print(itp + " ");
        System.out.println();
      } else {
        arr.set(i, temp);
        for (Integer itp : arr) System.out.print(itp + " ");
        System.out.println();
        break;
      }
    }
    if (i == 0) {
      arr.set(i, temp);
      for (Integer itp : arr) System.out.print(itp + " ");
      System.out.println();
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrTemp[i]);
      arr.add(arrItem);
    }

    Result.insertionSort1(n, arr);

    bufferedReader.close();
  }
}
