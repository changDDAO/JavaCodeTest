import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MuzyMukkBang {
    class Food{
        private final int time;
        private final int index;

        public Food(int time, int index) {
            this.time = time;
            this.index = index;
        }

        public int getTime() {
            return time;
        }

        public int getIndex() {
            return index;
        }
    }
    Comparator<Food> compTime = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return o1.getTime()-o2.getTime();
        }
    };
    Comparator<Food> compIndex = new Comparator<Food>() {
        @Override
        public int compare(Food o1, Food o2) {
            return o1.getIndex()-o2.getIndex();
        }
    };
    public int solution(int []food_times, long k){
        List<Food> foods = new LinkedList<>();
        int n = food_times.length;
        for(int i=0;i<n;i++){
            foods.add(new Food(food_times[i],i+1));
        }
        foods.sort(compTime);//음식을 먹는데 소요되는시간 순서대로 오름차순 정렬

        int preTime = 0;
        int idx = 0;
        for(Food food:foods){
            long dif = food.getTime()-preTime;
            if(dif!=0){
                long spendTime = dif*n;
                if(spendTime<=k){
                    k-=spendTime;
                    preTime =food.getTime();
                }else {
                    k%=n;
                    foods.subList(idx,foods.size()).sort(compIndex);
                    return foods.get(idx+(int)k).getIndex();
                }

            }
            idx++;
            n--;
        }
        return -1;
    }


}
