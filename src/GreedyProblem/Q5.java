package GreedyProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Ball implements Comparable<Ball>{
    private final int number;
    private final int weight;

    public Ball(int number, int weight) {
        this.number = number;
        this.weight = weight;
    }

    public int getNumber() {
        return number;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Ball o) {
        if(this.weight<o.weight)
            return -1;
        else return 1;
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //볼링공 번호와 최대무게 입력받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Ball> ballList = new ArrayList<>();
        for(int i=0;i<N;i++){
            ballList.add(new Ball(i+1,sc.nextInt()));
        }
        Collections.sort(ballList);
        //이러면 무게별로 정렬이 돼있음(오름차순)
        //근데 굳이 정렬한다고해서 빨라질껀없는듯
        //쉽게 풀수 있지만 가능한 많은 것들을 쓰면서 풀어보고싶었음!
        int answer =0;
        for(int i=0;i<ballList.size();i++){
            Ball ballA = ballList.get(i);
            for(int j=i+1;j<ballList.size();j++){
                Ball ballB = ballList.get(j);
                if(ballA.getNumber()!=ballB.getNumber()&&ballA.getWeight()!=ballB.getWeight())
                    answer++;
            }
        }
        System.out.println(answer);
    }

}
