import java.util.*;

class Solution {
    
    static int t, answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        answer = 0;
        t = target;
        
        back(numbers, 0, 0);
        
        return answer;
    }
    
    public static void back(int[] numbers, int cnt, int now) {
        
        if (cnt == numbers.length) {
            if (now == t) answer++;
            return;
        }
        
        back(numbers, cnt + 1, now + numbers[cnt]);
        back(numbers, cnt + 1, now - numbers[cnt]);
        
    }
    
}