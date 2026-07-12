import java.util.*;

class Solution {
    
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        boolean[] visited = new boolean[dungeons.length];
        
        back(dungeons, k, visited, 0);
        
        return answer;
        
    }
    
    public static void back(int[][] dungeons, int k, boolean[] visited, int cnt) {
        
        boolean flag = false;
        
        for (int i = 0; i < visited.length; i++) {
            
            if (!visited[i] && k >= dungeons[i][0]) {
                
                flag = true;
                
                visited[i] = true;
                back(dungeons, k - dungeons[i][1], visited, cnt + 1);
                visited[i] = false;
                
            }
            
        }
        
        if (!flag && cnt > answer) {
                
                answer = cnt;
                
            }
        
    }
    
}