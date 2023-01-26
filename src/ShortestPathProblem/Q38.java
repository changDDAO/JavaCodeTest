package ShortestPathProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q38 {
    //use floyd warshall algorithm 방향성 그래프로 표현이 가능하므로
    //ex) graph[a][b]의 값이 존재한다면 a<b이다 라고 생각할수 있음
    //문제는 정확한 순위 구하기 예를들어 특정 학생이 다른학생들과 모든 성적 비교가 가능하다면?
    // 그 특정 학생의 성적순위를 알 수 있음.
    public static int [][] graph = new int[501][501];
    public static int n,m;
    public static final int INF = (int)1e9;//무한대

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //입력받기
        //전체 학생수
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        //graph 초기화 해주기
        for(int i=0;i<501;i++){
            Arrays.fill(graph[i],INF);
        }
        //자기 자신으로 가는 값 0으로 초기화
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i==j)
                    graph[i][j]=0;
            }
        }
        //간선정보 입력받기
        String []info;
        for(int i=0;i<m;i++){
            s = br.readLine();
            info = s.split(" ");
            int a = Integer.parseInt(info[0]);
            int b = Integer.parseInt(info[1]);
            graph[a][b]=1;
        }
        //imp floyd warshall algo
        //이유를 곰곰히 생각해보면 graph[a][b]의 경우 a학생의 점수 < b학생의 점수를 나타낸것이다.
        //하지만 특정한 학생을 거쳐서도 a학생의 점수보다 b학생의 점수가 높다라는것을 알 수있으므로 수행을 꼭해주어야한다.
        for(int k =1;k<=n;k++){
            for(int a = 1;a<=n;a++){
                for(int b= 1;b<=n;b++){
                    graph[a][b] = Math.min(graph[a][b],graph[a][k]+graph[k][b]);
                }
            }
        }
        //특정학생을 뽑아 그학생이 다른학생들이랑 성적이 비교가 가능한지 체크
        int answer =0;
        for(int i=1;i<=n;i++){
            int cnt = 0;
            for(int j=1;j<=n;j++){
                if(graph[i][j]!=INF||graph[j][i]!=INF)//뽑힌 학생이 다른 학생들과 비교가 가능하다면
                    cnt++;
            }
            if(cnt==n)
                answer++;
        }
        System.out.println(answer);

    }
}
