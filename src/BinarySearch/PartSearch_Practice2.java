package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PartSearch_Practice2 {
    public static int binarySearch(int[] arr, int target, int start, int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==target)
                return mid;
            if(arr[mid]<target)
                start = mid+1;
            if(arr[mid]>target)
                end = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String []hadPart =br.readLine().split(" ");
        int [] hadPartNum = new int[N];
        for(int i=0;i<N;i++){
            hadPartNum[i]=Integer.parseInt(hadPart[i]);
        }
        int M = Integer.parseInt(br.readLine().trim());
        String []wantPart = br.readLine().split(" ");
        int []wantPartNum = new int[M];
        for(int i=0;i<M;i++){
            wantPartNum[i]=Integer.parseInt(wantPart[i]);
        }
        Arrays.sort(hadPartNum);//정렬해서 비교하자.
        for(int i=0;i<M;i++){
            int result = binarySearch(hadPartNum,wantPartNum[i],0,N-1);
            if(result!=-1)
                System.out.print("yes ");
            else System.out.print("no ");
        }



    }
}
