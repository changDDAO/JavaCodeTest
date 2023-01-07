package BinarySearch;

import java.util.Scanner;

// 재귀를 이용한 Binary Search Implementation
public class BinarySearch {
    public static int binarySearch(int []arr, int target, int start, int end){
    //찾는값이 arr에 없을 때
        if(start>end)
            return -1;
        int mid = (start+end)/2;
        if(arr[mid]==target)
            return mid;
        else if(target>arr[mid])
            return binarySearch(arr, target,mid+1,end);
        else {
            return binarySearch(arr, target, start, mid-1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("원소의 갯수와 찾고자 하는 값을 빈칸을 두고 입력하시오.");
        int n = sc.nextInt();
        int targetElement = sc.nextInt();
        int []intArr = new int[n];
        System.out.println("입력한 원소의 갯수만큼 element 값들을 입력하시오.");
        for(int i=0;i< intArr.length;i++){
            intArr[i]=sc.nextInt();// 처음에 향상된 for문을 이용하여 초기화 하려고했으나 debug 결과 향상된 for문의 경우 첫번째 인덱스값을
            //계속 변경시키며 초기화 하기때문에 첫번째 인덱스가 계속 변함... 주의하자
        }
        int answer = binarySearch(intArr, targetElement, 0, n-1 );
        if(answer==-1)
            System.out.println("찾는 원소가 없습니다.");
        else
            System.out.println(answer+1);

    }


}
