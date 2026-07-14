import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i < discount.length - 9; i++) {
            
            if (map.getOrDefault(discount[i], 0) == 0) continue;
            else { 
                
                boolean flag = false;
                
                flag = isPoss(discount, map, i);
                
                if (flag) answer++;
                
            }
            
        }
        
        return answer;
        
    }
    
    public boolean isPoss(String[] discount, Map<String, Integer> map, int k) {
        
        Map<String, Integer> copyMap = new HashMap<>(map);
        
        for (int i = 0; i < 10; i++) {
            
            String s = discount[k + i];
            
            if (copyMap.getOrDefault(s, 0) == 0) return false;
            
            copyMap.put(s, copyMap.get(s) - 1);
            if (copyMap.get(s) == 0) copyMap.remove(s);
            
        }
        
        return copyMap.isEmpty();
        
    }
}