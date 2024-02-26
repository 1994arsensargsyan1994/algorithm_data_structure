package lastStoneWeight;

import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 1){
            return  stones[0];
        }

        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pQueue.add(stone);
        }

        while (pQueue.size() > 1) {
            Integer poll1 = pQueue.poll();
            Integer poll2 = pQueue.poll();
            if (Objects.equals(poll1,poll2)){
                continue;
            } else {
                pQueue.offer(poll1 - poll2);
            }
            if (pQueue.size() == 1) {
                return pQueue.peek();
            }
        }

        return pQueue.isEmpty() ? 0 : pQueue.peek();
    }
}
