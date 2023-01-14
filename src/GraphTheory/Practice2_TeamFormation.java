package GraphTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Practice2_TeamFormation {
    public static int student, connect;
    //부모 노드 찾기
    public static int []parent = new int[100001];
    public static int findParent(int x){
        if(x==parent[x]) return x;
        return parent[x]=findParent(parent[x]);
    }
    //팀결성하기
    public static void unionTeam(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a<b)
            parent[b]=a;
        else
            parent[a]=b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        student = Integer.parseInt(st.nextToken());
        connect = Integer.parseInt(st.nextToken());
        //자기 자신으로 부모를 초기화
        for(int i=1;i<=student;i++){
            parent[i]=i;
        }
        //팀 연결하기
        for(int i=0;i<connect;i++){
        s = br.readLine().trim();
        st = new StringTokenizer(s);
        String detect = st.nextToken();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(detect.equals("0"))
            unionTeam(a,b);
        else if(detect.equals("1")){
            if(findParent(a)==findParent(b))
                System.out.println("YES");
            else System.out.println("NO");
        }
        }
     }
}
