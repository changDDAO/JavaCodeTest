package GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    private final int distance;
    private final int nodeA;
    private final int nodeB;

    public Edge(int distance, int nodeA, int nodeB) {
        this.distance = distance;
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public int getDistance() {
        return distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.distance < o.distance)
            return -1;
        else return 1;
    }
}

public class KruskalAlgorithm {
    //노드의 갯수 v , 간선의 갯수 e
    //노드갯수 100000개로 가정
    public static int v, e;
    public static int[] parent = new int[100001];
    //모든 간선과 비용을 담을 리스트
    public static ArrayList<Edge> edges = new ArrayList<>();
    public static int result = 0;

    //특정원소가 속한 집합찾기
    public static int findParent(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = findParent(parent[x]);

    }
    public static void unionParent(int a, int b){
        a=findParent(a);
        b=findParent(b);
        if(a<b)
            parent[b]=a;
        else parent[a]=b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        //노드 수와 간선 수 입력받기
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        for(int i=0;i<e;i++){//간선 초기화 해주기
            s=br.readLine();
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            edges.add(new Edge(d,a,b));
        }
        //부모테이블에서 부모 자신으로 초기화 하기
        for(int i=1;i<=v;i++){
            parent[i]=i;
        }
        //간선중 거리비용이 짧은순으로 오름차순 정렬
        Collections.sort(edges);
        for(Edge edge : edges){
            int distance = edge.getDistance();
            int a = edge.getNodeA();
            int b = edge.getNodeB();
            if(findParent(a)!=findParent(b)){
                unionParent(a,b);
                result+=distance;
            }

        }
        System.out.print("모든 노드를 다 연결하는 최소비용은? ");
        System.out.println(result);



    }
}
