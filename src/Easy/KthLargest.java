package Easy;

import java.util.PriorityQueue;

/**
 * @author Dark
 * @date 2019/5/20 9:39
 */
public class KthLargest {
    final PriorityQueue q;
    final int k;
    public KthLargest(int k , int[] nums){
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        for (int i : nums){
            add(i);
        }
    }

    public int add(int n){
        if (q.size() < k){
            q.offer(n);
        }else if ((int)q.peek() < n){
            q.poll();
            q.offer(n);
        }
        return (int)q.peek();
    }
}
