package SortingProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q23 {
    static class Student implements Comparable<Student> {
        private final String name;
        private final int kor;
        private final int english;
        private final int math;

        public Student(String name, int kor, int english, int math) {
            this.name = name;
            this.kor = kor;
            this.english = english;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Student o) {
            if(this.kor==o.kor&&this.english==o.english&&this.math==o.math) return (this.name.compareTo(o.name));
            if(this.kor==o.kor&&this.english==o.english) return o.math-this.math;
            if(this.kor==o.kor) return this.english-o.english;
            return o.kor-this.kor;
        }
    }
    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Student> students = new ArrayList<>();
        String s =br.readLine();
        int n = Integer.parseInt(s);

        for (int i=0; i<n;i++){
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math =Integer.parseInt(st.nextToken());
            students.add(new Student(name, kor, english, math));

        }
        Collections.sort(students);
        students.forEach((stud)-> System.out.println(stud.getName()));

    }
}
/*12          testcase
        Junkyu 50 60 100
        SangKeun 80 60 50
        Sunyoung 80 70 100
        Soong 50 60 90
        Haebin 50 60 100
        Kangsoo 60 80 100
        Donghyuk 80 60 100
        Sei 70 70 70
        Wonseob 70 70 90
        Sanghyun 70 70 80
        nsj 80 80 80
        Taewhan 50 60 90*/
