package GreedyProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {
    public static long answer =0;

    public static void main(String[] args) throws IOException {
        //두 수중 하나가 0 또는 1이라면 곱하지말고 더해야 가장큰 수가 된다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
      answer+=input.charAt(0)-'0';
      for(int i=1;i<input.length();i++){
          int nextValue = input.charAt(i)-'0';
          if(answer<=1||nextValue<=1)
              answer+=nextValue;
          else answer*=nextValue;
        }
        System.out.println(answer);
    }
}
