package DynamicProgrammingProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q32 {
    //전형적인 다이나믹 프로그래밍 Q32 정수삼각형
    public static int [][] dpTable = new int[500][500]; //dp table 생성

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String []nums;
        //몇층인지 입력받기
        int n = Integer.parseInt(s);
        for(int i=0;i<n;i++){
            s= br.readLine();
                nums=s.split(" ");//dpTable 입력받아 초기상태로 만들어두기
            for(int j=0;j<i+1;j++){
                dpTable[i][j]=Integer.parseInt(nums[j]);
            }
        }
        //다이나믹 프로그래밍으로 두번째줄부터 갱신하면서 최종값까지 변경
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                //지금 새롭게 형성한 dpTable에서 값 갱신 방향성은 왼쪽위 바로위 두가지
                int leftUp,  up;
                //왼쪽위
                if(j==0) leftUp=0;
                else leftUp = dpTable[i-1][j-1];
                //위에서 내려옴
                if(j==i) up = 0;
                else up = dpTable[i-1][j];

                //dpTable 갱신
                dpTable[i][j] = dpTable[i][j]+Math.max(leftUp,up);
            }
        }
        int answer = 0;
        for(int i=0;i<n;i++){
            //최대핪 찾기
            answer = Math.max(answer,dpTable[n-1][i]);
        }
        System.out.println(answer);

    }
}
