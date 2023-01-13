package ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class iNode implements Comparable<iNode> {
    private final int index;
    private final int distance;

    public iNode(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override// 거리가 짧은것이 우선 순위를 가지도록 설정
    public int compareTo(iNode o) {
        if (this.distance < o.distance)
            return -1;
        return 1;
    }
}

public class ImprovedDijkstraAlgorithm {
    //무한값으로 10억 설정
    public static final int INF = (int) 1e9;
    //노드 갯수,(N) , 간선의 갯수(M), 시작 노드번호(start)
    public static int n, m, start;
    //각 노드에 연결돼있는 노드를 표현
    public static ArrayList<ArrayList<iNode>> graph = new ArrayList<>();
    //최단거리 dpTable 생성
    public static int[] dpTable = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<iNode> pq = new PriorityQueue<>();
        //시작 노드로 가기위한 최단 경로는 0으로 설정
        pq.offer(new iNode(start, 0));
        dpTable[start] = 0;
        while (!pq.isEmpty()) {            //빈 큐가 아니라면
            iNode node = pq.poll(); //가장 거리가 짧은 노드 꺼내기
            int dist = node.getDistance(); //현재 노드까지의 비용
            int currentNode = node.getIndex(); // 현재 노드
            if (dpTable[currentNode] < dist)
                continue; //현재노드가 이미 처리된 노드라면 건너뛰기
            //현재 노드와 연결된 다른 노드들 확인
            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                int cost = dpTable[currentNode] + graph.get(currentNode).get(i).getDistance();//현재 노드를 거쳐서 다른 노드로 이동하는 비용
                if (cost < dpTable[graph.get(currentNode).get(i).getIndex()]) {//현재 노드를 거쳐서 다른 노드로 이동하는 거리비용이 기존 연결 거리비용보다 작다면
                    dpTable[graph.get(currentNode).get(i).getIndex()] = cost;//dpTable 최단거리 값 변경
                    pq.offer(new iNode(graph.get(currentNode).get(i).getIndex(), cost));
                }
            }


        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();
        //그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        //모든 간선 정보 입력
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new iNode(b,c));
        }

        //최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(dpTable,INF);
        dijkstra(start);//다익스트라 알고리즘 실행

        //모든 노드로 가는 최단거리 출력
        for(int i=1;i<=n;i++){
            if(dpTable[i]==INF)//즉 시작노드부터 시작하여 연결된 노드가 없다면
                System.out.println("INF");
            System.out.println(dpTable[i]);// 도달할 수있는 경우


        }
    }


}
