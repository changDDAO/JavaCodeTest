package GraphTheoryProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q41 {
    //도시랑 도로 여행계획에 속한 도시
    public static int n, m;
    //부모 테이블 초기화
    public static int [] parent = new int[501];
    public static int findParent(int x){
        if(parent[x]==x) return x;//종료조건
        return parent[x]=findParent(parent[x]);//수행동작
    }
    //두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b){
        a = findParent(a);
        b= findParent(b);
        if(a<b)
            parent[b]=a;
        else parent[a]=b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String []input = s.split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        // 부모테이블에서 자기자신 값으로 초기화 해주기
        for(int i=1;i<=n;i++) parent[i]=i;
        
        // n x n 입력받고 1일 때 union 해주기
        int []connectCheck;
        for(int i=0;i<n;i++){
            s = br.readLine();
            for(int j=0;j<n;j++){
                input = s.split(" ");
                connectCheck = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
                for(int temp: connectCheck){
                    if (temp==1) {//두 도시가 연결돼 있다면
                        unionParent(i+1,j+1);//합치기
                    }
                }
            }
        }
        //여행 계획 입력받기
        s = br.readLine();
       String [] p = s.split(" ");
       int [] plans = Arrays.stream(p).mapToInt(Integer::parseInt).toArray();
       boolean check = true;
       for(int i=0;i<m-1;i++){
           if (findParent(plans[i])!=findParent(plans[i+1]))
               check=false;
       }

       if(check)
           System.out.println("YES");
       else System.out.println("NO");

    



    }
}
