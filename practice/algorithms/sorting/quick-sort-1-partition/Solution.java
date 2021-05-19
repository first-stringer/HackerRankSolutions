import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/* 0018-HR: QUICKSORT 1 - PARTITION */

class Result {

  /*
   * Complete the 'quickSort' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> quickSort(List<Integer> arr) {
    // Write your code here
    int pivot = arr.get(0);
    List<Integer> left = new ArrayList<Integer>();
    List<Integer> equal = new ArrayList<Integer>();
    List<Integer> right = new ArrayList<Integer>();

    for (int i = 0; i < arr.size(); i++) {
      if (arr.get(i) < pivot) left.add(arr.get(i));
      if (arr.get(i) == pivot) equal.add(arr.get(i));
      if (arr.get(i) > pivot) right.add(arr.get(i));
    }

    left.addAll(equal);
    left.addAll(right);
    return left;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        // new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrTemp[i]);
      arr.add(arrItem);
    }

    List<Integer> result = Result.quickSort(arr);

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
