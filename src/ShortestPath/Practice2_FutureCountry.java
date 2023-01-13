package ShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Practice2_FutureCountry {
    //회사의 갯수(n) //연결된 통로(m) 최종목적지(x) 경유지(k)
    public static int n,m,x,k;
    public static final int INF = (int)1e9;
    //2차원 배열 그래프
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //최단거리 테이블 초기화
        for(int i=0;i<101;i++)
            Arrays.fill(graph[i],INF);

        //자기 자신으로 가는비용 0으로 초기화
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j)
                    graph[i][j]=0;
            }
        }

        //간선 입력받기.
        for(int i=0;i<m;i++){
            s = br.readLine();
            st = new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b]=1;
            graph[b][a]=1;//양방향이기 때문에
        }
        // use FloydWarshallAlgorithm
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    graph[j][k]=Math.min(graph[j][k],graph[j][i]+graph[i][k]);//i의 경우 각 회사의 인덱스로 생각하면 된다. 어렵지않다
                }
            }
        }
        s= br.readLine(); //x, k 입력받기
        st = new StringTokenizer(s);
        x = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(graph[1][k]+graph[k][x]>=INF)//1부터 경유지까지 + 경유지에서 목적지까지
            System.out.println(-1);
        else System.out.println(graph[1][k]+graph[k][x]);


    }

}
