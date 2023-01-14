package GreedyProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //목표는 최소 행동으로  같은 숫자 만들기
        //경우를 나눠보자 모두 0으로 바꿀까 모두 1로 바꿀까?
        int cntZero=0;
        int cntOne =0;
        if(input.charAt(0)=='1')//첫번째 값이 1이라면 0으로 바꾸는 cnt 증가
            cntZero+=1;
        if(input.charAt(0)=='0')//첫번째 값이 0이라면 1으로 바꾸는 cnt 증가
            cntOne+=1;
        for(int i=0;i<input.length()-1;i++){
            if(input.charAt(i)!=input.charAt(i+1)){
                if(input.charAt(i+1)=='0')
                    cntOne+=1;
                else cntZero+=1;
            }
        }
        int answer = Math.min(cntZero,cntOne);
        System.out.println(answer);

    }
}
