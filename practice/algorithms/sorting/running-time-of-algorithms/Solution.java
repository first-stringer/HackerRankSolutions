import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/* 0017-HR: RUNNING TIME OF ALGORITHMS */

class Result {

  static void swapPositions(List<Integer> arr, int p1, int p2) {
    Integer temp = arr.get(p1);
    arr.set(p1, arr.get(p2));
    arr.set(p2, temp);
  }

  /*
   * Complete the 'runningTime' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static int runningTime(List<Integer> arr) {
    // Write your code here
    int swapCount = 0;
    for (int i = 1; i < arr.size(); i++) {
      for (int j = i; j > 0 && arr.get(j) < arr.get(j - 1); j--) {
        swapPositions(arr, j - 1, j);
        swapCount++;
      }
    }
    return swapCount;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bufferedWriter = new BufferedWriter(new
    // FileWriter(System.getenv("OUTPUT_PATH")));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrTemp[i]);
      arr.add(arrItem);
    }

    int result = Result.runningTime(arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
