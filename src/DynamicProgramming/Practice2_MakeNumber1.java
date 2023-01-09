package DynamicProgramming;

import java.util.Scanner;

public class Practice2_MakeNumber1 {
    public static int [] dpTable = new int[30001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        //bottomUp
        for(int i = 2;i<=X;i++){
            //현재 i 값에서 1을 뺄때
            dpTable[i]=dpTable[i-1]+1;
            //현재 i값이 2로 나누어 질때
            if(i%2==0){
                dpTable[i]=Math.min(dpTable[i],dpTable[i/2]+1);
            }if(i%3==0){
                dpTable[i]=Math.min(dpTable[i],dpTable[i/3]+1);
            }if(i%5==0){
                dpTable[i]=Math.min(dpTable[i],dpTable[i/5]+1);
            }
        }
        System.out.print("연산을 하는 횟수의 최솟값은 : ");
        System.out.println(dpTable[X]);
    }
}
