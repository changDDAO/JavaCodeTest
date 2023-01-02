package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TST3_3 {
    public static void main(String[] args) throws IOException {
        long start =System.currentTimeMillis();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        StringTokenizer st = new StringTokenizer(s);
        String n = st.nextToken();
        String m = st.nextToken();
        int N = Integer.parseInt(n);
        int M = Integer.parseInt(m);
        int[][] numbers = new int[N][M];
        for (int i = 0; i < N; i++) {
            s = bufferedReader.readLine();
            st = new StringTokenizer(s);
            for (int j = 0; j < M; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer =0;
        for (int i = 0; i < N; i++) {

            int minValue = 10001;
            for (int j = 0; j < M; j++) {
                int number = numbers[i][j];
                minValue=Math.min(minValue,number);
            }
            answer=Math.max(minValue,answer);
        }
        System.out.println(answer);
        long end = System.currentTimeMillis();
        System.out.println("Buffer : "+(end-start));

        start = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);

        // a, b을 공백을 기준으로 구분하여 입력 받기

        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = 0;

        // 한 줄씩 입력 받아 확인하기
        for (int i = 0; i < a; i++) {
            // 현재 줄에서 '가장 작은 수' 찾기
            int min_value = 10001;
            for (int j = 0; j < b; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            // '가장 작은 수'들 중에서 가장 큰 수 찾기
            result = Math.max(result, min_value);
        }

        System.out.println(result); // 최종 답안 출력
        end =System.currentTimeMillis();
        System.out.println("Scanner : "+(end-start));
    //눈으로 보기전까지는 믿을 수없다. 확연히 Buffer의 경우 이중 for문 2번 사용했음에도 불구하고 Scanner에 비해 빨리나온다.
        //실제로 성능차이가 엄청나다는것 만약 단순한 입력이 아니라 많은 양의 입력을 받게된다면 엄청난 차이가 될 것이다. 사용습관을 잘
        //잘들이자
    }
}
