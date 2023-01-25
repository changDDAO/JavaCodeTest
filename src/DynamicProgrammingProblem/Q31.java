package DynamicProgrammingProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q31 {
    public static int testCase, n, m;
    public static int [][] arr = new int[20][20];
    public static int [][] dpTable = new int[20][20];
    public static void main(String[] args) throws IOException {
        //ts입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        testCase = Integer.parseInt(s);
        for(int t=0; t<testCase;t++) {
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = br.readLine();
            st = new StringTokenizer(s);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dpTable[i][j] = arr[i][j];
                }
            }
            for(int j= 1;j<m;j++){
                for(int i=0;i<n;i++){
                    //왼위, 왼, 왼밑에서 오는경우
                    int leftUp, left, leftDown;
                    if(i==0) leftUp = 0;
                    else leftUp = dpTable[i-1][j-1];
                    if(i==n-1)leftDown = 0;
                    else leftDown = dpTable[i+1][j-1];
                    left = dpTable[i][j-1];
                    dpTable[i][j]=dpTable[i][j]+Math.max(left,Math.max(leftUp,leftDown));
                }
            }
            int result =0;
            for(int i=0;i<n;i++){
                result = Math.max(result,dpTable[i][m-1]);
            }
            System.out.println(result);


        }

    }

}
