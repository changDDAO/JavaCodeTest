package GreedyProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //모험가 N 입력받기
        int N = Integer.parseInt(s);
        ArrayList<Integer> people = new ArrayList<>();
        //사람들 공포도 입력받기
        s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        for (int i = 0; i < N; i++) {
            int scare = Integer.parseInt(st.nextToken());
            people.add(scare);
        }
        //공포도 오름차순으로 정렬하기
        //공포도 이상만큼 사람수가 한그룹으로 구성되어야 하므로
        Collections.sort(people);

        int group = 0; //그룹수
        int person = 0; //사람수
        for (int i = 0; i < N; i++) {
            person += 1;
            if (person >= people.get(i)) {
                group += 1;
                person = 0;
            }

        }
        System.out.println(group);

    }
}
