package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        //재귀로 짜자
        //종료 조건
        if (start >= end)
            return;
        int pivot = start;
        //pivot을 제외한 가장 왼쪽 인덱스
        int left = start + 1;
        int right = end;
        while (left <= right) {
            //pivot보다 큰원소가 나올때까지 left 증가
            while (left <= end && arr[left] <= arr[pivot])
                left++;
            //pivot보다 작은원소가 나올때까지 right감소
            while (right > start && arr[right] >= arr[pivot])
                right--;
            if(left>right) {
                int temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            }else{
                int temp = arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
            }

        }
        //분할된 후 재귀적으로 Quick Sort수행
        quickSort(arr,start,right-1);
        quickSort(arr,right+1,end);
    }

    public static void main(String[] args) {
        int n = 10;
        int [] arr ={1,3,4,2,9,5,6,11,10,13};
        quickSort(arr,0,n-1);
        Arrays.stream(arr)
                .forEach(s-> System.out.print(s+" "));

    }
}
