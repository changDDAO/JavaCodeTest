import java.util.*;
class Solution{
    public int solution(String s){
        //1.문자열 단위별로 쪼개서 비교하기
        //2.단위별 비교후 문자가 같다면 cnt 증가시킨후 붙이기
        //3.단위별로 압축한 문자열 비교하여 최솟값 출력하기
        int answer = s.length();//계속 줄여나갈 대상
        StringBuilder compressed = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int cnt =1;
        for(int i = 1; i<s.length()/2+1;i++){//i는 단위
            compressed.setLength(0);
            String prev = s.substring(0,i);
            for(int j= i; j<s.length();j+=i){
                temp.setLength(0);
                for(int k=j;k<j+i;k++){
                    if(k<s.length())
                    temp.append(s.charAt(k));
                }
                if(prev.equals(temp.toString()))
                    cnt++;
                else{
                    //반복된 문자열이 2회 이상인것이 앞에 있다면
                    if(cnt>=2) compressed.append(cnt).append(prev);
                    else compressed.append(prev);
                    temp.setLength(0);
                    for(int k=j;k<j+i;k++){
                        if(k<s.length()) temp.append(s.charAt(k));
                    }
                    prev = temp.toString();
                    cnt=1;
                }

            }
            if(cnt>=2) compressed.append(cnt).append(prev);
            else compressed.append(prev);

            answer = Math.min(answer, compressed.length());

        }
        return answer;
    }
}