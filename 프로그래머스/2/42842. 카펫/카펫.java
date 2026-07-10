import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        int sum = (brown + 4) / 2;
        
        for (int i = 3; i <= sum / 2; i++) {
            
            int row = i;
            int col = sum - row;
            
            if ((row - 2) * (col - 2) == yellow) {
                answer[0] = col;
                answer[1] = row;
                break;
            }
            
        }
        
        return answer;
    }
}