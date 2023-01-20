package SortingProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q24 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String []inputs = input.split(" ");
        int [] intHouse = Arrays.stream(inputs).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> houses = new ArrayList<>();
        for(int element: intHouse){
            houses.add(element);
        }
        Collections.sort(houses);
        System.out.println(houses.get((n-1)/2));

    }
}
