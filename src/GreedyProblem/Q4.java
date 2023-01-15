package GreedyProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        //문제 요구사항 N갯수만큼 각 가격이 주어진 동전이 있고
        //그동전을 이용해서 만들수 없는 금액의 최솟값을 구해라
        ArrayList<Integer> coins = new ArrayList<>();
        for(int i =0;i<N;i++)
            coins.add(sc.nextInt());
        Collections.sort(coins);//금액이 적은 코인부터 오름차순으로 정렬하기
        Integer minValue =1;
        for(Integer coin:coins){
            if(minValue<coin)
                break;//만들수없는 최소금액코인보다 큰코인이 뽑힌다면 반복문 탈출
            minValue+=coin;
        }
        System.out.println(minValue);


    }
}
