package com.hacker.rank.solution;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/*
  https://www.hackerrank.com/challenges/birthday-cake-candles/problem?isFullScreen=true
 */

public class Birthday_Cake_Candles {
  class Result {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
      // Write your code here
      int tallest = 0;
      Map<Integer, Integer> candlesCount = new HashMap<>();
      for (Integer candle : candles){
        if(tallest < candle){
          tallest = candle;
        }
        candlesCount.put(candle, candlesCount.getOrDefault(candle, 0) + 1);
      }

      return candlesCount.get(tallest);
    }

  }

  public class Solution {
    public static void main(String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

      List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
          .map(Integer::parseInt)
          .collect(toList());

      int result = Result.birthdayCakeCandles(candles);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedReader.close();
      bufferedWriter.close();
    }
  }
}
