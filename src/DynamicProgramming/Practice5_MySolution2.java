package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Practice5_MySolution2 {
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
        int []dpTable = new int[m+1];
        Arrays.fill(dpTable,impossibleValue); //initialize 초기 dpTable

        //1.화폐단위 작은값부터 큰값으로 변경해가면서 dpTable 초기화 해주기
        //2.목표로 하는 m값을 작은화폐부터 구성해두고 화폐단위를 키워가면서
        //3.dpTable을 초기화 했을 때 비로소 우리는 화폐구성의 최솟값을 찾을수 있다!
        dpTable[0]=0;
        for (int i=0;i<n;i++){
            for(int j=moneyUnit[i];j<=m;j++){
                if(dpTable[j-moneyUnit[i]]!=impossibleValue)
                    dpTable[j]=Math.min(dpTable[j],dpTable[j-moneyUnit[i]]+1);
            }
        }
        if(dpTable[m]==impossibleValue)
            System.out.println(-1);
        else
            System.out.println(dpTable[m]);

    }
}
