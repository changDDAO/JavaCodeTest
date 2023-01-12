package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice5_MySolution {
    //값의 설정이 불가능한 값 초기화
    public static int impossibleValue = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //입력 받기 n,m
        String[] sInput = s.split(" ");
        int[] input = Arrays.stream(sInput).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int[] moneyUnit = new int[n];
        //화폐 단위 입력받기
        for (int i = 0; i < moneyUnit.length; i++) {
            moneyUnit[i] = Integer.parseInt(br.readLine());
        }
        //dpTable 초기화하기
        int[] dpTable = new int[m + 1];
        Arrays.fill(dpTable, impossibleValue);

        //입력된 화폐단위를 탐색하면서 초기화 해주기
        dpTable[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = moneyUnit[i]; j <= m; j++) {
                if (dpTable[j - moneyUnit[i]] != impossibleValue)
                    dpTable[j] = Math.min(dpTable[j], dpTable[j - moneyUnit[i]] + 1);
            }
        }
        int answer = dpTable[m];
        if (answer == impossibleValue)
            System.out.println(-1);
        else System.out.println(answer);


    }
}
