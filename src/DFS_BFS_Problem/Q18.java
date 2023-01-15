package DFS_BFS_Problem;
//균형잡힌 문자열
public class Q18 {
    public int balancedIndex(String p){//문자열을 0번 인덱스 부터 탐색하다가 '(',')'의 개수가 동일할 때 index 반환
        int cnt =0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='(')
                cnt++;
            else cnt --;
            if(cnt==0)
                return i;
        }
        return -1;//error
    }

    //올바른 괄호 문자열인지 판단하는 함수
    public boolean checkCorrect(String p){
        int cnt = 0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='(') cnt++; //문자열을 탐색하다가 '('를 만나면 cnt 증가
            else{
                if(cnt==0) return false;// 올바른 문자열이라면 (부터 시작해야하지만 cnt값이 0이라면 ')'부터 시작한것이므로 false반환
                cnt--;
            }
        }
        return true;
    }
    public String solution(String p){
        String answer = "";
        if(p.equals(""))
            return answer;
        int index = balancedIndex(p);
        String u = p.substring(0,index+1);//substring 함수 특성상 뒤에 오는 index 바로이전까지 잘림
        String v = p.substring(index+1);
        //만약 u가 올바른 괄호 문자열이라면 나머지 문자열 v를 재귀적으로 다시 수행후 결과를 이어붙임
        if(checkCorrect(u))
            answer = u+solution(v);
        //u가 올바른 괄호 문자열이 아니라면
        else{
            answer ="(";
            answer+=solution(v);
            answer+=")";
            u=u.substring(1,u.length()-1);//첫번째와 마지막 문자를 제거
            //뒤집은 문자열을 담을 String 변수 선언;
            String temp = "";
            for(int i=0;i<u.length();i++) {
                if (u.charAt(i) == '(')
                    temp += ")";
                else
                    temp += "(";
            }
             answer+=temp;

        }
            return answer;
    }

}
