package Implementation;

import java.util.Scanner;

public class RUD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        //L,R,U,D
        String []plans =sc.nextLine().split(" ");
        int []dx ={0,0,-1,1};
        int []dy = {-1,1,0,0};
        char[]plan={'L','R','U','D'};
        int x =1, y=1;
        for(String dir:plans){
            int nx =0,ny=0;
            for(int i=0;i<4;i++){
                if(plan[i]==dir.charAt(0)){
                    nx=x+dx[i];
                    ny= y+dy[i];

                }
            }
            if(nx<1||ny<1||nx>N||ny>N)
                continue;
            x=nx;
            y=ny;



        }
        System.out.println(x+" "+y);
        //다시 풀어보기



    }
}
