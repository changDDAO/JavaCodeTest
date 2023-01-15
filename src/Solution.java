class Solution {
    public int balancedIndex(String p){
        int cnt = 0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='(')
                cnt++;
            else cnt --;
            if(cnt==0)
                return i;
        }
        return -1;
    }
    public boolean checkCorrect(String p){
        int cnt =0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='(')
                cnt++;
            else{
                if(cnt==0)
                    return false;
                cnt--;
            }
        }
        return true;
    }
    public String solution(String p) {
        String answer = "";
        if(p.equals(""))
            return answer;
        int index = balancedIndex(p);
        String u = p.substring(0,index+1);
        String v = p.substring(index+1);
        if(checkCorrect(u))
            answer=u+solution(v);
        else{
            answer="(";
            answer+=solution(v);
            answer+=")";
            u=u.substring(1,u.length()-1);
            String temp ="";
            for(int i=0;i<u.length();i++){
                if(u.charAt(i)=='(')
                    temp+=")";
                else temp+="(";
            }
            answer+=temp;

        }
        return answer;
    }
}