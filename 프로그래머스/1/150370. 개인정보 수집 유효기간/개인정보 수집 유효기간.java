import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        boolean[] delete = new boolean[privacies.length];
        HashMap<String, Integer> term = new HashMap<>();
        
        for (String s : terms) {
            
            String[] part = s.split(" ");
            int t = Integer.parseInt(part[1]);
            term.put(part[0], t * 28);
            
        }
        
        int idx = 0;
        int[] users = new int[privacies.length];
        for (String s : privacies) {
            
            String[] part = s.split(" ");
            String date = part[0];
            
            String[] dates = date.split("\\.");
            users[idx++] = 336 * Integer.parseInt(dates[0]) + 28 * Integer.parseInt(dates[1]) + Integer.parseInt(dates[2]) + term.get(part[1]);
            
        }
        
        String[] todays = today.split("\\.");
        int to = 336 * Integer.parseInt(todays[0]) + 28 * Integer.parseInt(todays[1]) + Integer.parseInt(todays[2]);
        
        int cnt = 0;
        
        for (int i = 0; i < privacies.length; i++) {
            if (users[i] <= to) {
                delete[i] = true;
                cnt++;
            }
        }
        
        idx = 0;
        int[] answer = new int[cnt];
        for (int i = 0; i < privacies.length; i++) {
            if (delete[i]){
                answer[idx++] = i + 1;
            }
        }
        
        return answer;
    }
}