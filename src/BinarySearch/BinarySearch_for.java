package BinarySearch;

import java.util.Scanner;

public class BinarySearch_for {
    public static int forBinarySearch(int []arr, int target, int start, int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(target==arr[mid])
                return mid;
            else if(target>arr[mid])
                    start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기
        int n = sc.nextInt();
        int target = sc.nextInt();

        // 전체 원소 입력받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색 수행 결과 출력
        int result = forBinarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }
        else {
            System.out.println(result + 1);
        }
    }
}
