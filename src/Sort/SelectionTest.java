package Sort;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args) {
        int [] arr ={1,3,4,5,2,7,6,8,9,12};
        int n =10;

        for(int i=0;i<n;i++){
            int minIndex = i;
            for (int j=i+1;j<n;j++){
                if(arr[minIndex]>arr[j])
                    minIndex=j;
            }
            int temp = arr[i];
            arr[i]= arr[minIndex];
            arr[minIndex]=temp;

        }
        Arrays.stream(arr)
                .forEach(s-> System.out.print(s+" "));
    }
}
