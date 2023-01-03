package DFS_BFS;

import java.util.Scanner;

public class Practice3_answer {
    public static int [][] graph = new int[1000][1000];
    public static int n, m;
    public static boolean bfs(int x, int y){
        if(x<0||y<0||x>=n||y>=m)
            return false;
        if(graph[x][y]==0){
            graph[x][y]=1;
            bfs(x-1,y);
            bfs(x+1,y);
            bfs(x,y-1);
            bfs(x,y+1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m=sc.nextInt();
        sc.nextLine();//입력 버퍼 지우기
        for(int i=0;i<n;i++){
            String str = sc.nextLine();
            for(int j =0;j<m;j++){
                graph[i][j]= str.charAt(j)-'0';
            }
        }
        int result =0;
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(bfs(i,j))
                    result+=1;

            }
        }
        System.out.println(result);


    }
}
