package DFS_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static boolean []visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start]=true;
        while(!queue.isEmpty()){
            int x = queue.poll();
            System.out.print(x+" ");
            //뽑아낸 노드와 연결된 노드를 큐에 삽입
            for(int i =0;i<graph.get(x).size();i++){
                int adjacencyNode =graph.get(x).get(i);
                if(!visited[adjacencyNode]) {
                    queue.offer(adjacencyNode);
                    visited[adjacencyNode]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<9;i++){
            graph.add(new ArrayList<Integer>());
        }
        //1과 2 3 8
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        //2와 1 7
        graph.get(2).add(1);
        graph.get(2).add(7);

        //3과 1 4 5
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        //4와 3 5
        graph.get(4).add(3);
        graph.get(4).add(5);

        //5와 3
        graph.get(5).add(3);

        //6과 7
        graph.get(6).add(7);

        //7과 2 6 8
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        //8과 1 7
        graph.get(8).add(1);
        graph.get(8).add(7);
        bfs(1);
    }
}
