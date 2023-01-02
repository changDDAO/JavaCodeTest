package DFS_BFS;

import java.util.ArrayList;

public class DFS {
    public static boolean []visited = new boolean[9];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void dfs(int x){
        visited[x]=true;
        System.out.print(x+" ");
        for(int i =0;i<graph.get(x).size();i++){
            int adjacencyValue = graph.get(x).get(i);
            if(!visited[adjacencyValue])//만약 인접 노드를 방문하지 않았다면
                dfs(adjacencyValue);
        }

    }

    public static void main(String[] args) {
        for(int i =0; i<9;i++){
            graph.add(new ArrayList<>());
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

        dfs(1);



    }
}
