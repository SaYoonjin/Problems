import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] left = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            
            int now = 100 - progresses[i];
            
            if (now % speeds[i] == 0) left[i] = now / speeds[i];
            else left[i] = now / speeds[i] + 1;
            
        }
        
        List<Integer> days = new ArrayList<>();
        
        int idx = 0;
        
        while (idx < left.length) {
            
            int n = left[idx++];
            int cnt = 1;
            
            while (idx < left.length && left[idx] <= n) {
                cnt++;
                idx++;
            }

            days.add(cnt);          
            
        }
        
        int[] answer = new int[days.size()];
        
        for (int i = 0; i < days.size(); i++) {
            answer[i] = days.get(i);
        }
        
        return answer;
        
    }
}