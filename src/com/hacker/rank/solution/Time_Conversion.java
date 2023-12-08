package com.hacker.rank.solution;
import java.io.*;

/*
  https://www.hackerrank.com/challenges/time-conversion/problem?isFullScreen=true
 */
public class Time_Conversion {
  class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
      // Write your code here
      int hour = Integer.parseInt(s.substring(0,2));
      String sHour;
      if(s.substring(s.length() - 2).equals("PM")){
        if(hour == 12){
          sHour = "12";
        } else {
          sHour = "" + (hour + 12);
        }
      } else {
        if(hour == 12){
          sHour = "00";
        } else {
          sHour = "" + hour;
        }
      }

      if(sHour.length() == 1){
        sHour = "0" + sHour;
      }

      return sHour + s.substring(2, s.length() - 2);

    }

  }

  class Solution {
    public static void main(String[] args) throws IOException {


      String result = Result.timeConversion("06:40:03AM");
      System.out.printf(result);
    }
  }
}
