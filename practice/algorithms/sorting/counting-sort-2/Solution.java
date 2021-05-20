import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/* 0020-HR: COUNTING SORT 2 */

class Result {

  /*
   * Complete the 'countingSort' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here
    int[] counts = new int[100];
    List<Integer> sortedArr = new ArrayList<Integer>(arr.size());

    for (Integer number : arr) {
      counts[number]++;
    }

    for (int i = 0; i < counts.length; i++) {
      if (counts[i] == 0) continue;
      for (int j = 0; j < counts[i]; j++) sortedArr.add(i);
    }

    return sortedArr;
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

    List<Integer> result = Result.countingSort(arr);

    for (int i = 0; i < result.size(); i++) {
      bufferedWriter.write(String.valueOf(result.get(i)));

      if (i != result.size() - 1) {
        bufferedWriter.write(" ");
      }
    }

    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
