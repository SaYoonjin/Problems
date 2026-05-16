import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        
        answer = 0;
        
        dfs(0, 0, target, numbers);
        
        return answer;
        
    }
    
    public static void dfs(int score, int cnt, int target, int[] numbers) {
        
        if (cnt == numbers.length && score == target) {
            answer++;
            return;
        }
        
        else if (cnt == numbers.length) return;
        
        else {
            dfs(score + numbers[cnt], cnt + 1, target, numbers);
            dfs(score - numbers[cnt], cnt + 1, target, numbers);
        }
        
    }
}