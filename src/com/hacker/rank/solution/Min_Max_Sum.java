package com.hacker.rank.solution;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

/*
        https://www.hackerrank.com/challenges/mini-max-sum/problem?isFullScreen=true
 */
public class Min_Max_Sum {

  class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum (List<Integer> arr) {
      // Write your code here
      Integer minNum = arr.get(0);
      Integer maxNum = arr.get(0);
      Long totalSum = 0L;

      for (Integer num : arr) {
        if(num < minNum) {
          minNum = num;
        }

        if(num > maxNum) {
          maxNum = num;
        }

        totalSum += num;
      }

      System.out.print((totalSum - maxNum) + " " + (totalSum - minNum));
    }

  }

  public class Min_Max_Sum_1 {

    public static void main (String[] args) throws IOException {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

      List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
          .map(Integer::parseInt)
          .collect(toList());

      Result.miniMaxSum(arr);

      bufferedReader.close();
    }
  }
}