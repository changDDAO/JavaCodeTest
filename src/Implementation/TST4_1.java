package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TST4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String [] goTo = s.split(" ");
        //{L,R,U,D}
        int []dx ={0,0,-1,1};
        int []dy ={-1,1,0,0};
        char[] moveDir ={'L','R','U','D'};
        int x =1, y= 1;//start point
        for(String go : goTo) {
            char temp = go.charAt(0);
            int nx=0, ny=0;
            for(int j=0;j<4;j++){
                if(temp==moveDir[j]){
                    nx=x+dx[j];
                    ny= y+dy[j];
                }
            }
            if(nx<1||ny<1||nx>N||ny>N)
                continue;
            x=nx;
            y=ny;


        }
        System.out.println("최종 목적지의 좌표는 ?");
        System.out.println(x+" "+y);


    }
}
