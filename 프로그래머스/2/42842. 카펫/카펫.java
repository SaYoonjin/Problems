import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int total = brown + yellow;
        
        for (int i = 1; i <= yellow; i++) {
            
            if (yellow % i != 0) continue;
            
            int row = i;
            int col = yellow / i;
            
            int crow = row + 2;
            int ccol = col + 2;
            
            if (crow >= ccol && crow * ccol == total) {
                return new int[] {crow, ccol};
            }
            
        }
        
        return new int[] {};
        
    }
}