import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        
        int start = -1;
        List<Integer> list = new ArrayList<>();
        
        for (int x : arr) {
            
            if (start == x) continue;
            else {
                list.add(x);
                start = x;
            }
            
        }
        
        int[] answer = new int[list.size()];
        
        int idx = 0;
        for (int x : list) answer[idx++] = x;

        return answer;
    }
}