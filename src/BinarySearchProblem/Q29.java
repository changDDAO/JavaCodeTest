package BinarySearchProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q29 {
    //인접한 두 공유기 사이의 최소거리 :1
    //인접한 두 공유기 사이의 최대거리 :arr.get(n-1)-arr.get(0)
    public static void main(String[] args) {
        //입력받기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        List<Integer> houses = new ArrayList<>();
        //전체 하우스 좌표 입력받기
        for(int i =0;i<n;i++){
            houses.add(sc.nextInt());
        }
        //이진탐색을 수행하기위한 전제 조건 리스트 정렬하기.
        Collections.sort(houses);

        int start =1; //인접한 두공유기 사이의 최소거리
        int result = 0;
        int end = houses.get(n-1)-houses.get(0);//인접한 두공유기 사이의 가능한 최대 거리
        while(start<=end){
            int mid = (start+end)/2;
            int cnt =1;
            int standardHouse= houses.get(0);
            for(int i=1;i<n;i++){
                if(houses.get(i)>=standardHouse+mid) {
                    standardHouse=houses.get(i);
                    cnt++;
                }
            }
            if(cnt>=c){
                start = mid +1; //인접한 두공유기 사이 거리 늘리기
                result =mid;
            }else{
                end = mid-1; // 인접한 두 공유기 사이의 거리 좁히기
            }
        }
        System.out.println(result);


    }
}
