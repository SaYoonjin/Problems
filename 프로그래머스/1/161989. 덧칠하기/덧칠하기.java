import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        
        boolean[] isColored = new boolean[n + 1];
        int answer = 0;
        
        for (int s : section) {
            
            isColored[s] = true;
            
        }
        
        int cnt = 0;
        
        for (int i = 0; i < n + 1; i++) {
            
            if (isColored[i]) {
                
                answer++;
                
                while (cnt < m) {
                    
                    if (i + cnt < n + 1) {
                        isColored[i + cnt] = false;
                    }
                    
                    cnt++;
                    
                }
                
                cnt = 0;
                
            }
            
        }
        
        return answer;
        
    }
}