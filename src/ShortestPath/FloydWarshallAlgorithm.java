package ShortestPath;

import java.util.Arrays;
import java.util.Scanner;

//FloydWarshallAlgorithm의 경우 시간복잡도가 N^3 효율적이진 못하다.
public class FloydWarshallAlgorithm {
    public static final int INF = (int)1e9;//무한대 값 설정

    //노드의 갯수(n), 간선의 갯수(m)
    public static int n, m;
    //2차원 배열(그래프 표현)를 만들기
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n= sc.nextInt();
        m=sc.nextInt();

        //최단거리 테이블 모두 무한대로 초기화
        for(int i=0;i<501;i++){
            Arrays.fill(graph[i],INF);
        }
        //자기 자신으로 가는 비용 0으로 초기화
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==j)
                    graph[i][j]=0;
            }
        }

        //각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b]=c;
        }

        //점화식에 따른 FloydWarshallAlgorithm 수행
        for(int k=1;k<=n;k++){
            for(int a=1;a<=n;a++){
                for(int b=1;b<=n;b++){
                    graph[a][b]=Math.min(graph[a][b],graph[a][k]+graph[k][b]);
                }
            }
        }
        //결과 출력
        for(int a=1;a<=n;a++){
            for(int b=1;b<=n;b++){
                if(graph[a][b]==INF)
                    System.out.println("INF");
                System.out.print(graph[a][b]+" ");
            }
            System.out.println();
        }

    }


}
