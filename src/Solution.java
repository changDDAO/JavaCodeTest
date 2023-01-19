import java.util.*;
class Solution{
    public int solution(String s){
        int answer = s.length();
        //step 1부터 반까지 늘려가기(문자열의 갯수)
        for(int step =1; step<s.length()/2+1;step++) {
            String compressed = "";
            String prev = s.substring(0, step);//앞에서 부터 step크기만큼 문자열 추출
            int cnt = 1;
            //단위 크기만큼 증가시키며 이전 문자열과 비교
            for(int j = step; j<s.length();j+=step){
                String sub ="";
                for(int k=j;k<j+step;k++){
                    if(k<s.length())
                        sub+=s.charAt(k);
                }
                if(prev.equals(sub)) cnt+=1;
                else{
                    compressed+=(cnt>=2)?cnt+prev:prev;
                    sub="";
                    for (int k = j; k < j + step; k++) {
                        if(k<s.length())
                            sub+=s.charAt(k);
                    }
                     prev = sub;
                    cnt=1;
                }
            }
            compressed+=(cnt>=2)?cnt+prev:prev;
            answer = Math.min(answer,compressed.length());

        }
        return answer;

    }
}