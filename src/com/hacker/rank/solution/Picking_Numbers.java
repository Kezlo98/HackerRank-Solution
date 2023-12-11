package com.hacker.rank.solution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
  https://www.hackerrank.com/challenges/picking-numbers/problem?isFullScreen=true
 */

public class Picking_Numbers {
  public static void main(String[] args) throws IOException {
    List<Integer> a = Arrays.asList(4,6,5,3,3,1);

    int result = Result.pickingNumbers(a);

    System.out.printf("Result: " + result + "\n");

  }

  static class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
      // Write your code here
      int[] numArrays = new int[100];
      for (Integer num : a) {
        numArrays[num] +=  1;
      }
      int result = 2;
      for (int i = 1; i < 100; i++){
        int temp = numArrays[i] + numArrays[i - 1];
        if(result < temp){
          result = temp;
        }
      }
      return result;
    }

  }
}

