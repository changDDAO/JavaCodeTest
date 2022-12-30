package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class TST3_2 {
    public static void main(String[] args) throws IOException {
        long start = 0;
        long end = 0;
//        start = System.currentTimeMillis();
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//        end = System.currentTimeMillis();
//        System.out.println("scanner 걸린시간 : "+ (end-start));
//
//        start = System.currentTimeMillis();
//        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
//        String s= br.readLine();
//        String []strArr = s.split(" ");
//        for(int i=0;i< strArr.length;i++)
//            System.out.println(strArr[i]);
//        a = Integer.parseInt(strArr[0]);
//        b = Integer.parseInt(strArr[1]);
//        c = Integer.parseInt(strArr[2]);
//        end = System.currentTimeMillis();
//        System.out.println("BufferedReader 걸린시간 : "+(end-start));

        start=System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String [] input = s.split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        s = br.readLine();
        input = s.split(" ");
        int []numbers = new int[input.length];
        for(int i=0;i< input.length;i++){
            numbers[i]=Integer.parseInt(input[i]);
           // System.out.print(numbers[i]+" ");

        }
        Arrays.sort(numbers);
//        for(int i : numbers){
//            System.out.print(i+" ");
//        }
        int index = numbers.length-1;
        int firstNumber = numbers[index];
        int secondNumber = numbers[index-1];


        int result = 0;
        int cnt = (M/(K+1)*K)+(M%(K+1));
        result +=cnt*firstNumber;
        result += (M-cnt)*secondNumber;
        System.out.println(result);
        end = System.currentTimeMillis();
        System.out.println("프로그램 실행시간 (Buffer) : "+(end-start) );

        start = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        // N개의 수를 공백을 기준으로 구분하여 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr); // 입력 받은 수들 정렬하기
        int first = arr[n - 1]; // 가장 큰 수
        int second = arr[n - 2]; // 두 번째로 큰 수

        // 가장 큰 수가 더해지는 횟수 계산
        cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        result = 0;
        result += cnt * first; // 가장 큰 수 더하기
        result += (m - cnt) * second; // 두 번째로 큰 수 더하기

        System.out.println(result);
        end = System.currentTimeMillis();
        System.out.println("프로그램 걸린시간 (Scanner) : "+(end-start));






    }
}
