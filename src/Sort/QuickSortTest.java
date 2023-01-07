package Sort;

public class QuickSortTest {
    public static void quickSort(int []arr, int start, int end){
        //원소가 하나일 때 종료
        if(start>=end)
            return;
        int pivot = start;
        int left = start+1;
        int right = end;
        while(left<=right){
            while(left<=end&&arr[left]<arr[pivot])
                left++;// 왼쪽부터 pivot 보다 큰원소 찾기
            while(right>start&&arr[right]>arr[pivot])
                right--;
            if(left>right){//교차 됐다면
                int temp = arr[pivot];
                arr[pivot]=arr[right];
                arr[right]=temp;
            }else{
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
        }
        //pivot을 기준으로 왼쪽
        quickSort(arr,start,right-1);
        //pivot을 기준으로 오른쪽
        quickSort(arr,right+1,end);
    }

    public static void main(String[] args) {
        System.out.println("Quick Sort 정렬 >>");
        int []arr ={1,3,2,4,9,5,6,13,12,18};
        int n =10;
        quickSort(arr,0,n-1);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}
