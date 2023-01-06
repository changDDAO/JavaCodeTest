package Sort;

public class InsertionSort {
    public static void main(String[] args) {
        int n= 10;
        int[] arr = {1,2,7,3,4,5,9,8,6,13};
//Insertion Sort
        for(int i=1;i<n;i++){
            //현재 인덱스 기준으로 왼쪽 인덱스의 값과 비교(1 index까지만)
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){//현재 인덱스값이 정렬된 왼쪽 인덱스값과 비교 시 작다면 Insertion
                    int temp = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;

                }else break;
            }
        }
        for(int k:arr)
            System.out.print(k+" ");

    }
}
