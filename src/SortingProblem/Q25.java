package SortingProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class User implements Comparable<User>{
    private final int stage;
    private final double failRate;

    public User(int stage, double failRate) {
        this.stage = stage;
        this.failRate = failRate;
    }

    public int getStage() {
        return stage;
    }

    @Override
    public int compareTo(User o) {
        if(this.failRate==o.failRate)
            return this.stage-o.stage;
        return Double.compare(o.failRate,this.failRate);
    }
}

public class Q25 {
    public int []solution(int N, int[]stages){
        int []answer = new int[N];
        List<User> users = new ArrayList<>();
        int length = stages.length;
        //stage를 1부터 N까지 증가시키기
        for(int i=1;i<=N;i++){
            int cnt = 0;//각 스테이지에 머물러있는 인원계산
            for (int stage : stages) {
                if (stage == i) {
                    cnt++;
                }
            }
            double fRate = 0;
            //실패율 (스테이지에 도달했으나 아직 클리어하지 못한 플레이어 수/ 스테이지에 도달한 플레이어의 수)
            if(length>=1) fRate = (double)cnt/length;
            users.add(new User(i,fRate));
            length -= cnt;
        }
        Collections.sort(users);
        for(int i=0;i<users.size();i++){
            answer[i]=users.get(i).getStage();
        }
        return answer;
    }
}
