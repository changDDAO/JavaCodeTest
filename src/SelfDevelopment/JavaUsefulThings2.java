package SelfDevelopment;

import java.util.*;
import java.util.stream.Collectors;

public class JavaUsefulThings2 {
    public static void main(String[] args) {
        /*이펙티브 자바 아이템 46에 따르면, forEach 연산은
        최종 연산 중 기능이 가장 적고 가장 ‘덜’ 스트림답기 때문에,
        forEach 연산은 스트림 계산 결과를 보고할 때(주로 print 기능)만 사용하고
        계산하는 데는 쓰지 말자 라며, stream.forEach()의 사용에 주의를 준다.*/
        String [] testCase = {"changho", "jina","suck", "chen","jongho"};
        for (String name : testCase) {
            if (name.startsWith("c")) {
                System.out.println(name);
            }
        }

        List<String> stringList = Arrays.stream(testCase)
                .filter(s->s.startsWith("c"))
                .collect(Collectors.toList());
        System.out.println(stringList);

        /*Map에 값을 전체 출력하기 위해서는 entrySet(), keySet() 메소드를
        사용하면 되는데 entrySet() 메서드는 key와 value의 값이 모두 필요한 경우
    사용하고, keySet() 메서드는 key의 값만 필요한 경우 사용합니다.
*/
        Map<String, Integer> students = new HashMap<>();
        students.put("김진아",67);
        students.put("윤창호",81);
        students.put("권경운",93);
        students.put("이해창",31);
        students.put("구광모",47);

        //one way entrySet 사용하기
        for(Map.Entry<String, Integer> student : students.entrySet())
            System.out.println(" 이름 = " + student.getKey()+"// 점수 = "+student.getValue());

        //two way Iterator 사용하기
        for (Map.Entry<String, Integer> student : students.entrySet()) {
            System.out.println(" 이름 = " + student.getKey() + "// 점수 = " + student.getValue());

        }
        //three way lambda 사용
        students.forEach((key, value)-> System.out.println("Key : "+key+"// Value : "+value));

        //Stream 사용하기
        students.forEach((key, value) -> System.out.println("[key] : " + key + "[Value] : " + value));

        //Stream 사용하기 성적순으로 오름차순 Map.Entry의 경우 comparingByValue 와 comparingByKey 둘다 가능 개사기
        students.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println("이름 : "+entry.getKey()+" ---점수 : "+entry.getValue()));

    //Stream 사용하여 성적순으로 내림차순 정렬도 해보자
        students.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry-> System.out.println("이름 : "+entry.getKey()+ "***성적 : "+entry.getValue()));

    List<Map.Entry<String,Integer>> entryList= students.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        System.out.println(entryList);
        //성적순으로 80점이상인 사람만 뽑는데 그중 1등
        List<Map.Entry<String, Integer>> firstPerson =entryList.stream().filter(entry->entry.getValue()>80)
                .findFirst().stream().collect(Collectors.toList());// ㅄ같지만 되는지 해보고싶었음

        List<Map.Entry<String, Integer>> goodScoreStd =entryList.stream().filter(entry->entry.getValue()>80)
                .collect(Collectors.toList());
        System.out.println(firstPerson);
        System.out.println(goodScoreStd);






    }
}
