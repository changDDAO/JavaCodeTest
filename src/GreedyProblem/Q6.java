package GreedyProblem;

import java.util.*;

class Q6 {
    class Food{
        int time;
        int idx;
        Food(int time, int idx){
            this.time = time;
            this.idx = idx;
        }
    }

    Comparator<Food> CompTime = new Comparator<Food>(){
        public int compare(Food a, Food b){
            return a.time - b.time;
        }
    };

    Comparator<Food> CompIdx = new Comparator<Food>(){
        public int compare(Food a, Food b){
            return a.idx - b.idx;
        }
    };

    public int solution(int[] food_times, long k) {
        List<Food> foods = new LinkedList<Food>();
        int n = food_times.length;
        //파라미터로 들어온 food_times와 번호를 linkedList에 저장
        for(int i = 0; i < n; i ++){
            foods.add(new Food(food_times[i], i+1));
        }
        //음식을 다 먹는 순서가 짧은 순으로 오름차순 정렬
        foods.sort(CompTime);

        //시간 계산 
        int pretime = 0;
        int i = 0;
        for(Food f : foods){
            long diff = f.time - pretime;
            if(diff != 0){
                long spend = diff * n;
                if(spend <= k){
                    k -= spend;
                    pretime = f.time;
                }else{
                    k %= n;
                    foods.subList(i,food_times.length).sort(CompIdx);
                    return foods.get(i+(int)k).idx;

                }
            }
            i++;
            --n;
        }
        return -1;
    }
}