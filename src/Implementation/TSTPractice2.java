package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TSTPractice2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int row =(input.charAt(1)-'0');
        System.out.println("row = " + row);
        int column =(input.charAt(0)-'a')+1;
        System.out.println("column = " + column);
        //가능한 L자 이동정의
        int []dx ={2,2,-2,-2,-1,1,-1,1};
        int []dy ={-1,1,-1,1,2,2,-2,-2};
        //가능한 경우의 수 구하기.
        int result =0;

        for(int i=0;i<8;i++){
            int nextRow = row+dx[i];
            int nextColumn=column+dy[i];
            //조건을 만족한다면 경우의 수 증가.
            if(nextRow>=1&&nextRow<=8&&nextColumn>=1&&nextColumn<=8)
                result++;

        }
        System.out.println(result);

    }
}
