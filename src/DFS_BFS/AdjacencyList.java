package DFS_BFS;

import java.util.ArrayList;


public class AdjacencyList {


    public static void main(String[] args) {
    ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    for(int i=0;i<3;i++){
        graph.add(new ArrayList<Node>());
    }
    graph.get(0).add(new Node(1,7));
    graph.get(0).add(new Node(2,5));
    graph.get(1).add(new Node(0,7));
    graph.get(2).add(new Node(0,5));

    //graph 출력
        for(int i=0;i<3;i++){
            for(int j=0;j<graph.get(i).size();j++){
                graph.get(i).get(j).show();
            }
            System.out.println();
        }
    }
}
