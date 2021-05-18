import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

  /*
   * Complete the 'breakingRecords' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY scores as parameter.
   */

  /* 0012-HR: BREAKING THE RECORDS */
  public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
    int max = scores.get(0);
    int newMaxCount = 0;
    int min = scores.get(0);
    int newMinCount = 0;

    for (Integer score : scores) {
      if (score > max) {
        max = score;
        newMaxCount++;
      } else if (score < min) {
        min = score;
        newMinCount++;
      }
    }

    return Arrays.asList(newMaxCount, newMinCount);
  }
}

public class BreakingTheRecords {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter =
        // new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String[] scoresTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> scores = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int scoresItem = Integer.parseInt(scoresTemp[i]);
      scores.add(scoresItem);
    }

    List<Integer> result = Result.breakingRecords(scores);

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
