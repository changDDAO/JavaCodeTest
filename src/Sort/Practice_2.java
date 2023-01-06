package Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Practice_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Integer []arr =new Integer[N];
        for(int i=0;i<N;i++){
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        Arrays.stream(arr)
                .forEach(s-> System.out.print(s+" "));
        for(Integer i:arr){
            System.out.print(i);
        }
    }
}
