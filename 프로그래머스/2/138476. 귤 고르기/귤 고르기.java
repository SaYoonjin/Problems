import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        // 귤 중 k개 골라 상자 하나에 담아 판매
        // 1 3 2 5 4 5 2 3
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int t : tangerine) {
            
            map.put(t, map.getOrDefault(t, 0) + 1);
            
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        
        int answer = 0;
        
        while (k > 0) {
            
            int c = counts.get(answer++);
            k -= c;
            
        }
        
        return answer;
        
    }
}