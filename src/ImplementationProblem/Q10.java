package ImplementationProblem;

public class Q10 {
    public int solution(String s){
        int answer = s.length();
        //1개 단위부터 반까지 늘려가기
        for(int charCnt=1; charCnt<s.length()/2+1;charCnt++){
            String compressedString ="";
            String prev = s.substring(0,charCnt);//앞에서부터 문자 갯수만큼 추출
            int cnt =1;
            //문자 갯수만큼 증가시키며 이전 문자열과 비교
            for(int i=charCnt; i<s.length();i+=charCnt){
                //이전 문자와 동일하다면 압축횟수 증가
                String temp = "";
                for(int j=i;j<j+charCnt;j++){
                    if(j<s.length()) temp+=s.charAt(j);
                }
                if(prev.equals(temp))//이전 문자열과 동일하다면 cnt 증가
                    cnt++;
                //다른 문자열이라면
                else{
                    compressedString+=(cnt>2)?cnt+prev:prev;
                    temp="";
                    for(int j=i;j<i;j++){
                        if(j<s.length()) temp+=s.charAt(j);
                    }
                    cnt=1;//초기화
                    prev =temp;//초기화
                }
            }
            compressedString+=(cnt>2)?cnt+prev:prev;
            answer = Math.min(answer,compressedString.length());
        }
        return answer;
    }
}
