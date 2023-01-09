package DynamicProgramming;

import java.util.Scanner;

public class Fibonacci_Recursive {
    public static int fibo(int x){
        if(x==1||x==2)
            return 1;
        return fibo(x-1)+fibo(x-2);
    }
    public static void main(String[] args) {
        System.out.print("피보나치 수열에서 찾는 항 번호를 입력하시오>>");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println();
        System.out.println("answer = "+ fibo(n));


    }
}
