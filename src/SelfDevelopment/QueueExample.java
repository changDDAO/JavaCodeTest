package SelfDevelopment;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(4);
        queue.offer(11);
        queue.offer(17);
        queue.offer(5);
        queue.add(10);
        while(!queue.isEmpty()){
            System.out.println(queue.poll());

        }

    }

}
