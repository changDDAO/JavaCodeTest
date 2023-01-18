package ImplementationProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int divideIndex = input.length()/2;
        int left =0;
        int right =0;
        for(int i =0,j=input.length()-1; i<divideIndex;i++,j--){
            left+=input.charAt(i)-'0';
            right+=input.charAt(j)-'0';
        }
        if(left==right)
            System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
