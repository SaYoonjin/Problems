import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int N = commands.length;
        int[] answer = new int[N];
        
        for (int n = 0; n < N; n++) {
            
            int[] ta = new int[3];
            ta = commands[n];
            
            int i = ta[0];
            int j = ta[1];
            int k = ta[2];
            
            int[] target = new int[j - i + 1];
            
            int idx = 0;
            for (int x = i - 1; x < j; x++) {
                target[idx++] = array[x];
            }
            
            Arrays.sort(target);
            
            answer[n] = target[k - 1];
            
        }
        
        return answer;
    }
}