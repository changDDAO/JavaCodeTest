package Implementation;

import java.util.Scanner;

public class TST4_2 {
    public static boolean include3(int h, int m, int s){
        if(h%10==3||m/10==3||m%10==3||s/10==3||s%10==3){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        //n 입력
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt =0;
        for(int i=0;i<=N;i++){
            for(int j=0;j<60;j++){
                for(int k=0;k<60;k++){
                    if(include3(i,j,k))
                        cnt++;
                }
            }
        }
        System.out.println("0시 0분 0초부터 "+N+"시 59분 59초까지 3이 포함된 시간의 갯수는?");
        System.out.println(cnt);

    }
}
