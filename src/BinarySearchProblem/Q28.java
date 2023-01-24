package BinarySearchProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q28 {
    //use binary search (recursive)
    public static int recurBinarySearch(int[] arr, int start, int end){
        if(start>end) return -1;// 재귀함수 종료조건
        int mid = (start+end)/2;
        if(arr[mid]==mid)
            return mid;
        else if(arr[mid]>mid)
            return recurBinarySearch(arr,start,mid-1);//찾는값보다 중간값이 크다면 탐색 끝지점을 중간값인덱스보다 1작게
        else return recurBinarySearch(arr,mid+1,end);//찾는값보다 중간값이 작다면 탐색 첫지점을 중간값인덱스보다 1크게
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        int n = Integer.parseInt(s);
        int []arr = new int[n];
        s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for(int i=0; i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int answer = recurBinarySearch(arr, 0,n-1);
        System.out.println(answer);

    }


}
