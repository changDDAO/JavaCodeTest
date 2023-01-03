package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Temp {
    public static class Node{
        private final int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public static int n, m;

    public static int[][] graph = new int[200][200];
    public static int BFS(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            x= node.getX();
            y= node.getY();
            //방향 설정하기
            int[] dx ={1,-1,0,0};
            int []dy ={0,0,1,-1};
            //갈수있는 방향 순회하면서 조건에 따라 처리하기
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                //경계값 넘어가면 continue
                if(nx<0||ny<0||nx>=n||ny>=m)
                    continue;
                if(graph[nx][ny]==0)//괴물이 있는경우
                    continue;
                if(graph[nx][ny]==1){
                    graph[nx][ny]=graph[x][y]+1;
                    queue.offer(new Node(nx,ny));
                }

            }

        }
        return graph[n-1][m-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String []input = br.readLine().split(" ");
        n=Integer.parseInt(input[0]);
        m=Integer.parseInt(input[1]);
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                graph[i][j]= str.charAt(j)-'0';
            }
        }
        System.out.println(BFS(0,0));


    }

}
