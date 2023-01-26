package ShortestPathProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q37 {
    public static int[][] graph = new int[101][101];
    public static int n, m;
    public static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
    //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.parseInt(s);
        s = br.readLine();
        m = Integer.parseInt(s);
        //graph 초기화 해주기
        for(int i=0;i<101;i++){
            Arrays.fill(graph[i],INF);
        }
        //자기 자신은 0으로 초기화
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j) graph[i][j]=0;
            }
        }
        //간선 입력받은값으로 초기화
        String [] info;
        for(int i=0;i<m;i++){
            s=br.readLine();
            info = s.split(" ");
            int a = Integer.parseInt(info[0]);
            int b = Integer.parseInt(info[1]);
            int c = Integer.parseInt(info[2]);
            if(c<graph[a][b]) graph[a][b] =c;// 가장 최솟값으로 갱신
        }
        for(int k =1;k<=n;k++){
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(graph[i][j]==INF)
                    System.out.print(0+" ");
                else{
                    System.out.print(graph[i][j]+" ");
                }
            }
            System.out.println();
        }



    }
}
