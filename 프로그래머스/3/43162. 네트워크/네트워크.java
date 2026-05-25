import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<Integer>[] networks;
    
    public int solution(int n, int[][] computers) {
        
        // 1 1 0
        // 1 1 0
        // 0 0 1
        
        visited = new boolean[n + 1];
        
        networks = new ArrayList[n + 1];
        for (int i = 0; i < networks.length; i++) networks[i] = new ArrayList<>();
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[0].length; j++) {
                
                if (i == j) continue;
                
                else if (computers[i][j] == 1) {
                    
                    networks[i].add(j);
                    networks[j].add(i);
                    
                }
                
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i <= n; i++) {
            
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
            
        }
        
        return answer - 1;
        
    }
    
    public static void bfs(int num) {
        
        Queue<Integer> q = new ArrayDeque<>();
        visited[num] = true;
        q.offer(num);
        
        while (!q.isEmpty()) {
            
            int now = q.poll();
            
            for (int nn : networks[now]) {
                if (!visited[nn]) {
                    q.offer(nn);
                    visited[nn] = true;
                }
            }
            
        }
        
    }
}