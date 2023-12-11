package com.hacker.rank.solution;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Forming_A_Magic_Square {
  public static void main(String[] args) {
    Integer[][] sArray = {
        {4,8,2},
        {4,5,7},
        {6,1,6}
    };

    List<List<Integer>> s = Arrays.stream(sArray)
        .map(Arrays::asList)
        .collect(Collectors.toList());

    int result = Result.formingMagicSquare(s);

    System.out.printf("Result: " + result + "\n");

  }
}

class Result {

  /*
   * Complete the 'formingMagicSquare' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY s as parameter.
   */

  public static int formingMagicSquare(List<List<Integer>> s) {
    // Write your code here
    Integer[][][] magicSquareArray = {
        {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
        {{8,1,6},{3,5,7},{4,9,2}},
        {{6,1,8},{7,5,3},{2,9,4}},
        {{4,3,8},{9,5,1},{2,7,6}},
        {{4,9,2},{3,5,7},{8,1,6}},
        {{6,7,2},{1,5,9},{8,3,4}},
        {{2,9,4},{7,5,3},{6,1,8}},
        {{2,7,6},{9,5,1},{4,3,8}}
    };

    int minCost = Integer.MAX_VALUE;

    for (Integer[][] magicSquare : magicSquareArray){
      int cost = 0;
      for (int i = 0; i < 3; i ++){
        for (int j = 0; j < 3; j ++){
          int tempCost = s.get(i).get(j) - magicSquare[i][j];
          if(tempCost < 0){
            cost -= tempCost;
          } else {
            cost += tempCost;
          }
        }
      }
      if(minCost > cost){
        minCost = cost;
      }
    }

    return minCost;
  }

}