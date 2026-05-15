import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> q = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++) {
            
            q.offer(new int[] {priorities[i], i});
            
        }
        
        int answer = 0;
        
        while (true) {
            
            boolean flag = false;
            int[] now = q.poll();
            
            for (int[] item : q) {
                if (item[0] > now[0]) {
                    q.offer(now);
                    flag = true;
                    break;
                }
            }
            
            if(!flag && now[1] == location) return answer + 1;
            else if (!flag) answer++;
            
        }
                
    }
}