package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Practice3 {
    public static int [][] graph = new int[1000][1000];
    public static int N, M;//row column 입력받을 변수
    public static boolean dfs(int x, int y){
        if(x<0||x>=N||y<0||y>=M)
            return false;
        //상, 하 , 좌, 우 재귀 실행
        if(graph[x][y]==0) {
            graph[x][y]=1;
            dfs(x + 1, y); //하
            dfs(x - 1, y);//상
            dfs(x, y - 1);//좌
            dfs(x, y + 1);//우
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        StringTokenizer st = new StringTokenizer(input);
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        for (int i=0;i<N;i++){
            input = br.readLine().trim();
            for(int j=0;j<M;j++){
             graph[i][j]=input.charAt(j)-'0';
            }
        }
        int answer =0;
        for (int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(dfs(i,j))
                    answer+=1;

            }
        }
        System.out.println(answer);



    }
}
