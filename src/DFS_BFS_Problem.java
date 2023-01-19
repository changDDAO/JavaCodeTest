import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS_BFS_Problem {
    //도시의 개수 n , 도로의 개수 m, 거리정보 k, 출발도시 x, 출발도시는 0
    public static int n, m, k, x;
    //모든 도시에 대한 최단거리
    public static int [] distance = new int[300001];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
            distance[i]=-1;

        }
        //간선 입력받기
        for(int i=1;i<=m;i++){
            s = br.readLine();
            st=new StringTokenizer(s);
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        //출발지점 표시하기
        distance[x]=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            for(int i =0;i<graph.get(currentNode).size();i++){
                int nextNode = graph.get(currentNode).get(i);
                if(distance[nextNode]==-1){
                    distance[nextNode]=distance[currentNode]+1;
                    queue.offer(nextNode);
                }
            }
        }
        //최단거리가 k인 도시를 오름차순으로 출력하기
        boolean flag =false;
        for (int i =1;i<=n;i++){
            if(distance[i]==k) System.out.print(i);
            flag = true;
        }
        if(!flag) System.out.println(-1);

    }
}
