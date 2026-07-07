import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int[] time = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            
            int n = 100 - progresses[i];
            if (n % speeds[i] == 0) time[i] = n / speeds[i];
            else time[i] = n / speeds[i] + 1;
            
        }
        
        List<Integer> list = new ArrayList<>();
        
        int current = time[0];
        int count = 1;
        
        for (int i = 1; i < time.length; i++) {
            
            if (time[i] <= current) {
                count++;
            } else {
                list.add(count);
                current = time[i];
                count = 1;
            }
        }
        
        list.add(count);
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
        
    }
}