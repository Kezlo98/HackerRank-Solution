package com.hacker.rank.solution.climbing_the_Leaderboard;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

class Result {

  /*
   * Complete the 'climbingLeaderboard' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY ranked
   *  2. INTEGER_ARRAY player
   */

  public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here

    Map<Integer,Integer> rankedMap = new HashMap<>();
    List<Integer> rankedDistinct = new ArrayList<>();
    int currentRank = 1;
    for (Integer integer : ranked) {
      if(rankedMap.containsKey(integer)) {
        continue;
      }
      rankedMap.put(integer, currentRank);
      currentRank++;
      rankedDistinct.add(integer);
    }

    int i = rankedDistinct.size() - 1;
    List<Integer> result = new ArrayList<>();
    for (Integer score : player){
      while (0 < i && rankedDistinct.get(i) <= score){
        i--;
      }
      int rank = rankedMap.get(rankedDistinct.get(i)) + 1;
      if(i == 0 && rankedDistinct.get(i) < score){
        rank --;
      }
      result.add(rank);
    }

    return result;
  }

}

public class Solution {
  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    List<Integer> result = Result.climbingLeaderboard(ranked, player);

    bufferedWriter.write(
        result.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
