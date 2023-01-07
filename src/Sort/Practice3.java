package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ScoreOrder implements Comparable<ScoreOrder>{
    String name;
    int score;

    public ScoreOrder(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(ScoreOrder o) {
        if(this.score<o.score)
            return -1;
        else
            return 1;

    }
}
public class Practice3 {
    public static String name = "";
    public static int score = 0;
    public static void main(String[] args) throws IOException {
        List<ScoreOrder> scoreOrderList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        for(int i=0;i<N;i++){
            String []input = br.readLine().split(" ");
            name = input[0];
            score = Integer.parseInt(input[1]);
            scoreOrderList.add(new ScoreOrder(name,score));
        }
        Collections.sort(scoreOrderList);
        for(ScoreOrder std:scoreOrderList){
            System.out.print(std.getName()+" ");
        }
    }

}
