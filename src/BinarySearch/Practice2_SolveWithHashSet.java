package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Practice2_SolveWithHashSet {
    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.charAt(0)-'0';
        input=br.readLine();
        String[] partsArr = input.split(" ");
        int[] intPartsArr = new int[partsArr.length];
        for(int i=0; i<intPartsArr.length;i++){
            intPartsArr[i] = Integer.parseInt(partsArr[i]);
        }
        HashSet<Integer> parts = new HashSet<>();
        for(Integer i:intPartsArr)
            parts.add(i);
        int M = Integer.parseInt(br.readLine());
        input=br.readLine();
        String[] partsArr2 = input.split(" ");
        /*int [] arr = Arrays.stream(partsArr2).mapToInt(Integer::parseInt).toArray();
        for(int i:arr)
            System.out.print(i+" ");*/ //stream을 이용하여 편하게 변경하자.
        int[] intPartsArr2 = new int[partsArr2.length];
        for(int i=0; i<intPartsArr2.length;i++) {
            intPartsArr2[i] = Integer.parseInt(partsArr2[i]);
        }
        for(int i=0;i<M;i++){
            if(parts.contains(intPartsArr2[i]))
                System.out.print("yes ");
            else System.out.print("no ");
        }

    }

}
