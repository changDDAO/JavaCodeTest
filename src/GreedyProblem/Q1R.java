package GreedyProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Q1 문제 재풀이
//생각 정리
// 현재 최대한 많은 그룹수를 만들어 return 해줘야됨
//그러기 위해선 공포도 리스트를 오름차순 정렬하여
//사람수가 공포도 이상이라면 하나의 그룹을 결성해주면 가장많은
//그룹을 결성할 수 있을 것으로 보임
public class Q1R {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.parseInt(s);
        s = br.readLine();
        String [] scareSize = s.split(" ");
        List<Integer> people = Arrays.stream(scareSize)
                .mapToInt(Integer::parseInt).boxed().sorted().collect(Collectors.toList());//현재 입력받은 String [] 공포도를
        // 오름차순 sort 하여 Integer type List형식으로 반환하도록 함.(stream 사용해서 한번에 처리)
//        System.out.println(people);
        //처음에 사고했던 대로 공포도를 오름차순하여 정렬했을 때 사람수와 공포도를 비교하며 가장많은 그룹을 결성할 수 있음

        int person = 0;
        int group = 0;
        for(int i=0;i<n;i++){
            person++;//공포도를 하나참조할 때마다 사람수 증가
            if(person>=people.get(i)){
                group++;
                person =0;//그룹을 결성 해주었으므로 사람 cnt 초기화
            }
        }
        System.out.println(group);

    }
}
