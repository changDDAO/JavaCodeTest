package SelfDevelopment;

import java.util.*;
import java.util.stream.Collectors;

public class JavaUsefulMethod {
    public static void main(String[] args) {
        //배열의 특정 범위 자르기
        int[] intArr = {3, 8, 11, 14, 2, 7, 5};
        int[] tmp = Arrays.copyOfRange(intArr, 0, 3);
        List<Integer> list = Arrays.stream(tmp).boxed().collect(Collectors.toList());
        System.out.println(list);
        //use binarySearch method 찾은 인덱스 값 반환
        // 중요한 부분은 binary Search할 때 오름차순 정렬을 꼭 해주어야함!!!!!
        //정렬 해주지않는다면 -1 찾지못했다고 판단
        Arrays.sort(intArr);
        int index = Arrays.binarySearch(intArr, 14);
        System.out.println(index);

        // 1. length
        int[] arr = new int[3];
        System.out.println(arr.length);

// 2. length()
        String str = "java";
        System.out.println(str.length());

// 3. size()
        List<Integer> list2 = new ArrayList<>();
        System.out.println(list2.size());
//String Method Example
        String testInput ="Hello my name is chang ho";
        String leftCut =testInput.substring(0,5);
        System.out.println(leftCut);
        String rightCut = testInput.substring(5);
        System.out.println(rightCut);

        //대문자로 변경
        System.out.println(leftCut.toUpperCase());
        //소문자로 변경
        System.out.println(leftCut.toLowerCase());

        //PriorityQueue 사용해보기 MinHeap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(5);
        pq.offer(4);
        pq.offer(1);
        pq.offer(2);
        while(!pq.isEmpty()){
            Integer i =pq.poll();
            System.out.println(i);
        }
        //MaxHeap
PriorityQueue<Integer> reversePq = new PriorityQueue<>(Collections.reverseOrder());
        reversePq.offer(5);
        reversePq.offer(4);
        reversePq.offer(1);
        reversePq.offer(2);
        while(!reversePq.isEmpty()){
            Integer i =reversePq.poll();
            System.out.println(i);
        }
    }
}
