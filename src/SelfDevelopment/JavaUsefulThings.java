package SelfDevelopment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaUsefulThings {
    public static void main(String[] args) {
        //대문자 알파벳을 제외한(^는 부정기호) 모든 것을 대체
        //ex1)
        String ex1= "Kimchi is Delicious";
        String result = ex1.replaceAll("[^A-Z]","*");
        System.out.println(result);

        //변수 최대 최소 초기화
        int iMin = Integer.MIN_VALUE;
        int mMin = Integer.MAX_VALUE;
        System.out.println("iMin = " + iMin);
        System.out.println("mMin = " + mMin);
        
//        Character to int 
        char A = '3';
        System.out.println("(int)A = " + (int)A); // ascII 값으로 나온다 '0'이 48임
        int a = '3'-'0';
        System.out.println("a = " + a);
        //another way
        int aa = Character.getNumericValue(A);
        System.out.println("aa = " + aa);

        //int to Character
        char AA = (char)(aa+'0');
        System.out.println(AA);
        //Array에서 max값 찾기
        int []arr = {1,3,10,13,15,11,145};
        int max = Arrays.stream(arr).max().getAsInt();
        System.out.println("arr 배열의 max = " + max);
        //Array값의 합
        int sum = Arrays.stream(arr).sum();
        System.out.println("arr 배열의 sum = " + sum);
        //배열을 제네릭 타입으로 즉 Integer로 변환하기
        List<Integer> iList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(iList);
        //filter 이용해서 원하는값 찾기
        int target = iList.stream().filter(n->n>5)
                .findFirst()
                .orElse(0);
        System.out.println(target);

    }


}
