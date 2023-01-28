package GraphTheoryProblem;

import java.util.Scanner;

public class Q42 {
    public static int[] parent = new int[100001];
    public static int g, p;
    public static int findParent(int x){
        if(parent[x]==x)
            return x;
        return parent[x] = findParent(parent[x]);
    }
    public static void unionParent(int a, int b){
        a=findParent(a);
        b=findParent(b);
        if(a<b) parent[b]=a;
        else parent[a]=b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //탑승구, 비행기수 입력받기
        g = sc.nextInt();
        p = sc.nextInt();
        for(int i=0;i<=g;i++){
            parent[i]=i;//탑승구를 자기 자신으로 초기화
        }
        int answer= 0;
        for(int i=0;i<p;i++){
            int plane= sc.nextInt();
            int root = findParent(plane);
            if(root ==0) break;
            unionParent(root,root-1);
            answer++;

        }
        System.out.println(answer);

    }
}
