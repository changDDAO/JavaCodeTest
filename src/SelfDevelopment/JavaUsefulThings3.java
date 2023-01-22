package SelfDevelopment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaUsefulThings3 {
    public static void main(String[] args) {
        class Product{
            private final int amount;
            private final String name;

            public Product(int amount, String name) {
                this.amount = amount;
                this.name = name;
            }


            public String getName() {
                return name;
            }
        }
        //Math class 이용하기
        //절댓값
        int a = Math.abs(-39);
        System.out.println(a);
        //제곱근
        a = (int) Math.sqrt(100);
        System.out.println(a);

        //제곱
        a = (int)Math.pow(2,3); //2의 3 제곱근 8출력 예상
        System.out.println(a);

        //알아두면 유용한 함수들
        //substring의 경우 특정 인덱스 부터 특정인덱스 전의 인덱스까지 뽑아 String 형태로 반환해줌
        String str = "ABCDEFG";
        String fixStr = str.substring(0,4);//쉽게 말해서 특정인덱스부터 몇개 element인지 뒤에서 앞에 파라미터의
        //뺄셈이 결국 반환되는 문자열의 길이임 헷갈릴 필요xx
        System.out.println("str = " + str);
        System.out.println("fixStr = " + fixStr);
        //repeat함수 특정 문자열을 반복함
        String repeatString = fixStr.repeat(3);
        System.out.println("repeatString = " + repeatString);

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(23, "potatoes"));
        productList.add(new Product(14, "orange"));
        productList.add(new Product(13, "lemon"));
        productList.add(new Product(23, "sugar"));
        productList.add(new Product(11, "bread"));
        productList.add(new Product(11, "bread"));
    //상품 이름만 출력하기
        List<String> nameList = productList.stream()
            .map(Product::getName).collect(Collectors.toList());
        System.out.println(nameList);

        //상품이름에서 중복된 값을 지우고 set형태로 반환하기


        Set<String> nameList2 = productList.stream()
                .map(Product::getName).collect(Collectors.toSet());
        System.out.println(nameList2);
        
        
       /* Stream에서 작업한 결과를 1개의 String으로 이어붙이기를 원하는 경우에 Collectors.joining()을 이용할 수 있다. Collectors.joining()은 총 3개의 인자를 받을 수 있는데, 이를 이용하면 간단하게 String을 조합할 수 있다.

        delimiter : 각 요소 중간에 들어가 요소를 구분시켜주는 구분자
        prefix : 결과 맨 앞에 붙는 문자
        suffix : 결과 맨 뒤에 붙는 문자*/
        
        String listToString = productList.stream().map(Product::getName)
                .collect(Collectors.joining());
        System.out.println("listToString = " + listToString);

        listToString = productList.stream().map(Product::getName).collect(Collectors.joining(" "));
        System.out.println("listToString(2) = " + listToString);

        listToString = productList.stream().map(Product::getName).collect(Collectors.joining(" ","*",">"));
        System.out.println("listToString(3) = " + listToString);

    }
}
