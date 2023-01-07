package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SeqeuntialSearch {
    public static int sequentialSearch(int n, String target, String[] list){
        //list 전체결과 출력
        for(int i=0;i<n;i++){
            System.out.println(list[i]);
            if(list[i].equals(target)) {
                return i + 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int n = Integer.parseInt(st.nextToken());
        String targetName = st.nextToken();
        System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
        s = br.readLine();
        String []nameList = s.split(" ");
        int answer= sequentialSearch(n,targetName,nameList);
        System.out.print("찾고자 하는 문자열은 "+answer+"번에 있습니다.");

    }
}
