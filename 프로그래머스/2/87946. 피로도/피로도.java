import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        // 최소 필요 피로도, 소모 피로도
        
        boolean[] visited = new boolean[dungeons.length];
        
        back(k, dungeons, visited, 0);
        
        return answer;
        
    }
    
    public static void back(int k, int[][] dungeons, boolean[] visited, int cnt) {
        
        answer = Math.max(answer, cnt);
        
        if (k < 1) return;
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= k) { 
                visited[i] = true;
                
                back(k - dungeons[i][1], dungeons, visited, cnt + 1);
                
                visited[i] = false;
            }
        }
        
    }
}