package DynamicProgramming;

import java.util.Scanner;

public class Practice3_AntWarrior {
    public static int [] dpTable = new int[100];//initialize dp table

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int [] foodAmount = new int[N];
        for(int i=0;i<N;i++){
            foodAmount[i]=sc.nextInt();
        }
        dpTable[0]=foodAmount[0];
        //첫번째 음식양과 두번째 음식양중 큰값을 dp에 저장 (가지고 올수 있는 음식량의 최댓값을 가지고 오는것이 문제)
        dpTable[1]=Math.max(foodAmount[0],foodAmount[1]);
        for(int i=2;i<N;i++){
            dpTable[i]=Math.max(dpTable[i-1],dpTable[i-2]+foodAmount[i]);
        }
        System.out.print("개미 전사가 약탈할 수 있는 음식양의 최댓값은 : ");
        System.out.println(dpTable[N-1]);

    }
}
