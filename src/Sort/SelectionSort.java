package Sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int n = 10;
        int [] arr ={1,3,2,6,5,9,8,7,4,13};

        for(int i=0;i<n;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[minIndex]>arr[j])
                    minIndex=j;
            }
            //swap
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;


        }
        Arrays.stream(arr)
                .forEach(s-> System.out.print(s+" "));
    }
}
