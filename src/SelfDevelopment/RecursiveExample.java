package SelfDevelopment;

public class RecursiveExample {
    public static void recursive(){
        System.out.println("재귀함수를 호출합니다.");
        recursive();
    }
    public static void main(String[] args) {
        recursive();
        //depth 범위 벗어나면 StackOverflowError 발생.

    }
}
