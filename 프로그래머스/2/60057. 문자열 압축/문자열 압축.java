import java.util.*;

class Solution {
    public int solution(String s) {
        
        int n = s.length();
        int answer = n;
        
        for (int i = 1; i <= n / 2; i++) {
            
            int idx = i, result = 0, cnt = 1;
            String prev = s.substring(0, i);
            
            boolean stop = false;
            
            while (idx < n) {
                
                int end = Math.min(idx + i, n);
                String now = s.substring(idx, end);
                
                if (prev.equals(now)) {
                    cnt++;
                }
                else {
                    if (cnt > 1) result += String.valueOf(cnt).length();
                    result += prev.length();
                    
                    if (result >= answer) {
                        stop = true;
                        break;
                    }
                    
                    prev = now;
                    cnt = 1;
                }
                
                idx += i;
                
            }
            
            if (stop) continue;
            
            if (cnt > 1) result += String.valueOf(cnt).length();
            result += prev.length();
            
            answer = Math.min(answer, result);
            
        }
        
        return answer;
        
    }
}