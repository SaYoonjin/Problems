import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int idx1 = 0, idx2 = 0;
        String answer = "Yes";
        
        for(int i = 0; i < goal.length; i++) {
            
            String s = goal[i];
            
            if (idx1 < cards1.length && s.equals(cards1[idx1])) {
                idx1++;
            }
            else if (idx2 < cards2.length && s.equals(cards2[idx2])) {
                idx2++;
            }
            else answer = "No";
            
        }
        
        return answer;
        
    }
}