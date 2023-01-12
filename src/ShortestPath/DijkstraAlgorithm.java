package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node{
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }
}
public class DijkstraAlgorithm {
    //무한을 의미하는 값 설정
    public static int INF =(int)1e9;
    //노드의 갯수(n), 간선의 갯수(m), 시작정점(start)
    public static int n, m, start;

    //각 노드에 연결돼있는 노드정보 담기
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    //방문한 적이 있는 노드인지 check
    public static boolean[] visited = new boolean[100001];

    // 시작 정점부터 최단 거리 테이블 만들기
    public static int []dpTable = new int[100001];

    //방문하지 않은 노드중에서 최단거리가 짧은 노드 인덱스 반환
    public static int getSmallestNode(){
        int minDistance =INF;
        int index =0;
        for(int i=1;i<=n;i++){
            if(!visited[i]&&dpTable[i]<minDistance){
                minDistance=dpTable[i];
                index=i;
            }
        }
        return index;
    }

    //dijkstra
    public static void dijkstra(int start){
        //시작노드를 기준으로 각 노드와의 distance 즉, dpTable 초기화
        dpTable[start]=0;
        visited[start]=true;
        //시작노드를 기준으로 각 노드와의 distance 즉, dpTable 초기화
        for(int i=0;i<graph.get(start).size();i++){
            dpTable[graph.get(start).get(i).getIndex()]=graph.get(start).get(i).getDistance();
        }
        //시작 노드를 제외한 전체 n-1개의 노드에 대하여 반복
        for(int j=0;j<n-1;j++){
            //현재 최단 거리가 가장 짧은 노드를 방문처리
            int currentNode = getSmallestNode();
            visited[currentNode]=true;
            //현재 노드와 연결된 다른노드 확인
            for(int k=0;k<graph.get(currentNode).size();k++){
                //현재 노드를 통해 특정노드와의 거리 합
                int cost = dpTable[currentNode]+graph.get(currentNode).get(k).getDistance();
                //현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더짧은경우
                if(cost<dpTable[graph.get(currentNode).get(k).getIndex()])
                    dpTable[graph.get(currentNode).get(k).getIndex()]=cost;
            }
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        // 모든 간선 정보를 입력받기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(dpTable, INF);

        // 다익스트라 알고리즘을 수행
        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (dpTable[i] == INF) System.out.println("INFINITY");
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(dpTable[i]);
            }
        }

    }


}
