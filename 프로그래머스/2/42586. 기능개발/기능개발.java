import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] nums = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            
            int p = progresses[i];
            int s = speeds[i];
            
            int r = 0;
            if ((100 - p) % s == 0) r = (100 - p) / s;
            else r = (100 - p) / s + 1;
            
            nums[i] = r;
            
        }
        
        List<Integer> list = new ArrayList<>();
        
        int idx = 0, cnt = 0, now = 0;;
        
        while (idx < progresses.length) {
            
            if (cnt == 0) {
                now = nums[idx++];
                cnt++;
            }
            
            else if (now >= nums[idx]) {
                cnt++;
                idx++;
            }
            
            else if (now < nums[idx]) {
                list.add(cnt);
                cnt = 0;
            }
             
        }
        
        // 마지막 거 추가해야 함
        if (cnt > 0) list.add(cnt);
        
        idx = 0;
        int[] answer = new int[list.size()];
        for (int l : list) {
            answer[idx++] = l;
        }
        
        return answer;
        
    }
}