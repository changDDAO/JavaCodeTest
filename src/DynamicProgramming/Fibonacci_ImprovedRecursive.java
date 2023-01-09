package DynamicProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Fibonacci_ImprovedRecursive {
    public static long[] savedValue = new long[100];

    public static long fibo(int x){
        if(x==1||x==2){
            return 1;
        }
        if(savedValue[x]!=0){
            return savedValue[x];
        }else {
            savedValue[x]=fibo(x-1)+fibo(x-2);
            return fibo(x-1)+fibo(x-2);
        }

    }

    public static void main(String[] args)  {
        List<Long> saveLongValue;
        try {
            while (true) {
                Scanner sc = new Scanner(System.in);
                System.out.println("피보나치 항을 입력하시오>>");
                int s = sc.nextInt();
                fibo(s);
                System.out.println("배열에 저장된 값>>");
                saveLongValue = Arrays.stream(savedValue).filter(i -> i != 0).boxed().collect(Collectors.toList());
                System.out.println(saveLongValue);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
