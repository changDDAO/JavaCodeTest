package SelfDevelopment;

public class CompareIterAndRecur {
    public static int iterFactorial(int n){
        int result = 1;
        for(int i=1;i<=n;i++){
            result*=i;
        }
        return result;

    }
    public static int recurFactorial(int n){
        if(n==1)
            return 1;
        return n*recurFactorial(n-1);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long s = iterFactorial(15);
        System.out.println("s = " + s);
        long end = System.currentTimeMillis();
        System.out.println("프로그램 실행시간 : iter "+(end-start));
        System.out.println();

        start = System.currentTimeMillis();
        s=recurFactorial(15);
        System.out.println("s = " + s);
        end = System.currentTimeMillis();
        System.out.println("프로그램 실행시간 : recur "+(end-start));




    }

}
