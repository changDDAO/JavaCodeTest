package BinarySearch;

import java.util.Scanner;

public class PartSearch_CountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int []arr = new int[1000001];
        for(int i=0;i<n;i++){
            int part = sc.nextInt();
            arr[part]=1;
        }
        int m = sc.nextInt();
        int []targets = new int[m];
        //찾아야 하는 부품번호를 부품 수 만큼 배열 초기화
        for(int j=0;j<m;j++){
            targets[j]=sc.nextInt();
            if(arr[targets[j]]==1)
                System.out.print("yes ");
            else
                System.out.print("no ");
        }



    }
}
