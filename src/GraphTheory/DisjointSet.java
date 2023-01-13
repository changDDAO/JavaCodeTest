package GraphTheory;

import java.util.Scanner;

public class DisjointSet {
    //노드의 갯수(v)
    //간선의 갯수(e)
    public static int v, e;
    // 부모테이블 초기화
    public static int[] parent = new int[100001];

    public static int findParent(int x) {
        if (x == parent[x])//루트 노드라면
            return x; //루트 노드 index 반환
        return parent[x]= findParent(parent[x]);// 루트노드가 아니면 재귀적으로 특정노드의 부모 계속하여 호출
    }//경로압축기법

    //두원소가 속한 집합을 합치기
    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b)
            parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();
        //부모테이블 자기 자신으로 초기화..
        for(int i=1;i<=v;i++){
            parent[i]=i;
        }
//        union 연산수행
        for(int j=0;j<e;j++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a,b);
        }

        //각 원소가 속한 집합 출력하기
        System.out.print("각 원소가 속한 집합: ");
        for(int i=1;i<=v;i++){
            System.out.print(findParent(i)+" ");
        }
        System.out.println();

        //부모테이블 출력하기
        System.out.print("부모 테이블 : ");
        for(int i=1; i<=v;i++){
            System.out.print(parent[i]+" ");
        }

    }


}
