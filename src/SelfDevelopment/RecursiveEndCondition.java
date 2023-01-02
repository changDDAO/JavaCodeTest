package SelfDevelopment;

public class RecursiveEndCondition {
    public static void recursiveEnd(int i){
        if(i==100)
            return;
        System.out.println("recursiveEnd("+i+")에서 recursiveEnd("+(i+1)+")를 호출합니다.");
        recursiveEnd(i+1);
        System.out.println("recursiveEnd("+i+")를 종료합니다.");
    }

    public static void main(String[] args) {
        recursiveEnd(1);
    }
}
