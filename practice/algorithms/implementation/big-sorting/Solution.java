import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

  static int partition(String numStrings[], int low, int high) {
    String pivot = numStrings[high];
    int i = (low - 1);

    for (int j = low; j < high; j++) {
      if (new BigInteger(numStrings[j]).compareTo(new BigInteger(pivot)) <= 0) {
        i++;
        String temp = numStrings[i];
        numStrings[i] = numStrings[j];
        numStrings[j] = temp;
      }
    }

    String temp = numStrings[i + 1];
    numStrings[i + 1] = numStrings[high];
    numStrings[high] = temp;

    return (i + 1);
  }

  static void quickSort(String numStrings[], int low, int high) {
    if (low < high) {
      int pi = partition(numStrings, low, high);
      quickSort(numStrings, low, pi - 1);
      quickSort(numStrings, pi + 1, high);
    }
  }

  /*
   * Complete the 'bigSorting' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY unsorted as parameter.
   */

  /* 0014-HR: BIG SORTING */
  public static List<String> bigSorting(List<String> unsorted) {
    // Write your code here
    String[] numStrings = unsorted.toArray(new String[0]);
    Result.quickSort(numStrings, 0, unsorted.size() - 1);
    return Arrays.asList(numStrings);
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
