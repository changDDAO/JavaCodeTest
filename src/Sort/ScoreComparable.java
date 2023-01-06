package Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{
    private final String name;
    private final int score;

    public Student(String name, int score) {

        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Student o) {
        if(this.score<o.score)
            return-1;
        else return 1;
    }
}
public class ScoreComparable {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("윤창호",91));
        students.add(new Student("윤종호",78));
        students.add(new Student("윤지경",32));
        Collections.sort(students);
        for(Student s:students)
            System.out.println(s.getName()+"의 성적은 : "+s.getScore());
    }

}
