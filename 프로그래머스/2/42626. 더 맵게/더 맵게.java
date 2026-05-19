import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.offer(s);
        }
        
        int answer = 0;
        
        while (pq.peek() < K) {
            
            if (pq.size() < 2) {
                return -1;
            }
            
            int a = pq.poll();
            int b = pq.poll();
            
            int mixed = a + (b * 2);
            pq.offer(mixed);
            
            answer++;
        }
        
        return answer;
    }
}