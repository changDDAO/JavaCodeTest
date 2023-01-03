package DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Practice4 {
    public static int n, m;
    public static int[][] graph = new int[200][200];

    //이동할 수 있는 방향
    public static int []dx ={1,-1,0,0};
    public static int []dy ={0,0,1,-1};//상, 하, 좌, 우
    public static class NODE{
        private final int x, y;

        public NODE(int x, int y) {
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

    public static int bfs(int x, int y){
        Queue<NODE> queue = new LinkedList<>();
        queue.offer(new NODE(x,y));
        while(!queue.isEmpty()){
            NODE node = queue.poll();
            x =node.getX();
            y = node.getY();
            //방향정하기
            for(int i=0;i<4;i++){
                int nx= x+dx[i];
                int ny = y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m)
                    continue;

                if(graph[nx][ny]==0)
                    continue;

                if(graph[nx][ny]==1){
                    graph[nx][ny]=graph[x][y]+1;
                    queue.offer(new NODE(nx,ny));
                }


            }
        }
        return graph[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m= scanner.nextInt();
        scanner.nextLine();//입력버퍼 비우기
        for(int i=0;i<n;i++){
            String str = scanner.nextLine();
            for (int j=0;j<m;j++){
                graph[i][j]=str.charAt(j)-'0';
            }
        }
        int answer = bfs(0,0);
        System.out.println(answer);


    }




}
