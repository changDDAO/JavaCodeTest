package GraphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologySort {

    //노드의 갯수 v, 간선의 갯수 e
    //노드의 갯수 최대 100000
    public static int v, e;
    //진입 차수 0으로 초기화
    public static int [] inDegree = new int[100001];
    // 각노드에 연결된 간선정보를 담는 리스트 초기화
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    //topology sort method
    public static void topologySort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        //진입차수가 0인 노드를 queue에 삽입
        for(int i=1;i<=v;i++){
            if(inDegree[i]==0)
                queue.offer(i);
        }
        // queue가 빌 때까지 반복
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            result.add(currentNode);
            //뽑힌 원소와 연결된 노드들의 진입차수 1씩 빼기
            for(int i=0;i<graph.get(currentNode).size();i++){
                inDegree[graph.get(currentNode).get(i)]-=1;

                //만약 진입차수가 0이 되는 노드가 있다면 큐에삽입
                if(inDegree[graph.get(currentNode).get(i)]==0){
                    queue.offer(graph.get(currentNode).get(i));
                }
            }
        }
        //위상정렬 결과 출력
        for(int order : result)
            System.out.print(order+" ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        //graph 초기화
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }

        //방향그래프의 모든 간선 정보를 입력받기
        for(int i=0;i<e;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            inDegree[b]+=1;//진입차수를 1증가
        }
        topologySort();

    }

}
