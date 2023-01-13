package GraphTheory;

import java.util.Scanner;

public class DetectCycle {
    //노드의 갯수(v) 왁 간선의 갯수(e)
    public static int v, e;
    public static int[] parent = new int[100001];//부모테이블 초기화
    //특정원소가 속한 집합찾기
    public static int findParent(int x){
        if(x==parent[x])
            return x;
        return parent[x]=findParent(parent[x]);
    }
    // 두 원소가 속한 집합을 합치기
    public static void unionParent(int a, int b){
        a=findParent(a);
        b= findParent(b);
        if(a<b)
            parent[b]=a;
        else parent[a]=b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        //부모테이블 자기 자신으로 초기화
        for(int i=1;i<=v;i++){
            parent[i]=i;
        }
        boolean cycle = false;//사이클 발생여부
        for(int j=0;j<e;j++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(findParent(a)==findParent(b)){
                cycle = true;
                break;
            }
            unionParent(a,b);
        }
        if(cycle)
            System.out.println("사이클이 발생했습니다. ");
        else {
            System.out.println("사이클이 발생하지 않았습니다.");
            System.out.print("각 원소가 속한 집합 : ");
            for(int i=1;i<=v;i++){
                System.out.print(parent[i]+" ");
            }
        }
    }
}
