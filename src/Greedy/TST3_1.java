package Greedy;

import java.util.Scanner;

public class TST3_1 {
    public static void main(String[] args) {
        // 최소동전으로 바꿀 금액을 입력하자.
        System.out.print("최소 동전으로 교환할 금액을 입력하시오.>>");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int temp = N;
        int cnt = 0;

        int[] coinType = {500, 100, 50, 10};
        for (int i = 0; i < coinType.length; i++) {
            cnt += N / coinType[i];
            N%=coinType[i];

        }

        System.out.println(temp+"원을 교환할 최소 동전의 개수는 : "+ cnt);

    }
}
