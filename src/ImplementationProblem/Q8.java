package ImplementationProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Character> alphaList = new ArrayList<>();
        int numSum =0;
        for(int i=0;i<input.length();i++){
            if(Character.isAlphabetic(input.charAt(i)))
                alphaList.add(input.charAt(i));
            else numSum+=input.charAt(i)-'0';
        }
        Collections.sort(alphaList);
        for(Character temp: alphaList){
            System.out.print(temp);
        }
        if(numSum!=0){
            System.out.println(numSum);
        }

    }
}
