package DFS_BFS_Problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q16 {
    public static int n, m;
    public static int answer; // 울타리가 어디에 세워지냐에 따라 결과값이 바뀔수 있으므로 전역변수로 선언
    public static int[][] arr = new int[8][8]; //초기 구성
    public static int[][] changedArr = new int[8][8]; // 벽 설치후 바뀐구성

    //방향설정
    public static int[] dx = {1, 0, -1, 0}; //하 왼 상 우
    public static int[] dy = {0, -1, 0, 1};

    //바이러스 정의 dfs 사용
    public static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                if (changedArr[nx][ny] == 0) {
                    changedArr[nx][ny] = 2;
                    virus(nx, ny);//바이러스는 특정지점으로부터 사방으로 퍼짐을 정의 한것임
                }
            }
        }
    }
    // 벽을 3개 세우고 난 후 안전한영역의 크기 계산
    public static int getSafeZone(){
        int safeZone = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(changedArr[i][j]==0)
                    safeZone++;
            }
        }
        return safeZone;
    }

    public static void dfs(int wall){
        if(wall == 3){
            for(int i=0;i<n;i++){
                if (m >= 0) System.arraycopy(arr[i], 0, changedArr[i], 0, m);
            }
            //벽이 3개 설치된 장소에서 바이러스 탐색후 전파시키기
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if (changedArr[i][j]==2)
                        virus(i,j);
                }
            }
            answer = Math.max(answer, getSafeZone());
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==0){
                    wall++;
                    arr[i][j]=1;
                    dfs(wall);
                    arr[i][j]=0;
                    wall--;
                }//처음에는 잘이해가 안됐지만 잘따라가보면 1 1 1 차례로 벽을 세운 후 벽이 3개라 종료됐을 때 가장 최근에 변경해줬던 인덱스를
                //다시 초기화 해주므로 1 1 0 이 되고 for문을 돌면서 다음 인덱스에서0을 찾은후 그값이 1로 변경되면서 cnt가 3이되었을 때 안전한 영역을 계산해주고
                // 종료되고 다시 0으로 초기화 된후에 그다음 인덱스를 참조하여 값확인 후 계속하여 처리(1 1 0 1 -> 1 1 0 0 1 이런 느낌) dfs(2)->dfs(3)

                //dfs(2)가 종료됐다면 두번째 인덱스 값이 0으로 초기화 되어있고 for문에 의해 다음 인덱스를 참조하여 0일 때 1로 변경 1 0 1 1 -> 1 0 1 0 1 이런 느낌으로 진행될 것임
            }
        }    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        String [] info;
        for(int i=0;i<n;i++){
            s = br.readLine();
            info = s.split(" ");
            int []temp = Arrays.stream(info).mapToInt(Integer::parseInt).toArray();
            arr[i]=Arrays.copyOfRange(temp,0,temp.length);
        }

        dfs(0);
        System.out.println(answer);


    }
}