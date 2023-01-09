package SelfDevelopment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample2 {
    public static void main(String[] args) {
        //String [] to int [] 바꾸기
        String [] numbers={"5","4","17","39"};
     //use stream
        int []intNum = Stream.of(numbers).mapToInt(Integer::parseInt).toArray();
        for(int i: intNum)
            System.out.print(i+" ");
        System.out.println();
        //use stream
        intNum= Arrays.stream(numbers).mapToInt(Integer::parseInt).toArray();
        for(int i: intNum)
            System.out.print(i+" ");
        System.out.println();
        //sorting
        Arrays.sort(intNum);
        for(int i: intNum)
            System.out.print(i+" ");
        System.out.println();
        //reverseOrder Method를 사용하기 위해서는 Integer로 형변환 제네릭 타입 반드시필요
        List<Integer> intList = Stream.of(numbers).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Collections.sort(intList,Collections.reverseOrder());
        System.out.print("역순으로 ");
        for(Integer i: intList)
            System.out.print(i+" ");

    }
}
