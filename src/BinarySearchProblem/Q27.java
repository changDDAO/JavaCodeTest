package BinarySearchProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q27 {
    //target 값의 가장 왼쪽 인덱스를 반환하는 함수
    public static int findLeftIndex(int[] arr, int target, int start, int end){
        while(start<end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
    //실행 결과 right index의 경우 내가 찾는값의 제일 오른쪽 인덱스 +1의 값을 돌려준다
    public static int findRightIndex(int[] arr, int target, int start, int end){
        while(start<end) {
        int mid = (start + end) / 2;
        if (arr[mid] > target) {
            end = mid;
        } else {
            start = mid + 1;
        }
    }
        return end;
    }
    public static int countRange(int []arr, int leftValue, int rightValue){
       int leftIndex = findLeftIndex(arr, leftValue,0,arr.length);
       int rightIndex = findRightIndex(arr, rightValue,0,arr.length);
       return rightIndex-leftIndex;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        s = br.readLine();
        st = new StringTokenizer(s);
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        System.out.println("arr 배열에서 "+ x +" 값의 갯수는?");
        int answer= countRange(arr,x,x);
        if(countRange(arr,x,x)==0)
            System.out.println(-1);
        else System.out.println(answer);


    }

}
