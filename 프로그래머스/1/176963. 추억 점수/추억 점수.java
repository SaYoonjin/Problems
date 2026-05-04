import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < name.length; i++) {
            
            String s = name[i];
            int in = yearning[i];
            
            map.put(s, in);
            
        }
        
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < photo.length; i++) {
            
            int result = 0;
            for (String s : photo[i]) {
                
                int score = map.getOrDefault(s, 0);
                result += score;
                
            }
            answer[i] = result;
            
        }
        
        return answer;
        
    }
}