import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        // 가격이 떨어지지 않은 기간은 몇 초인지
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            
            int now = prices[i];    // 1 
            int cnt = 1;
            for (int j = i + 1; j < prices.length; j++){
                
                if (prices[j] < now || j == prices.length - 1) {
                    answer[i] = cnt;
                    break;
                }
                else cnt++;
                
            }
            
        }
        
        return answer;
        
    }
}