import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        // 1 1 0
        // 1 1 0
        // 0 0 1
        
        List<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < arr.length; i++) arr[i] = new ArrayList<>();
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                
                if (i == j) continue;
                
                if (computers[i][j] == 1) {
                    
                    arr[i].add(j);
                    arr[j].add(i);
                    
                }
                
            }
        }
        
        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < visited.length; i++) {
            
            if (!visited[i]) {
                
                visited[i] = true;
                answer++;
                dfs(i, arr);
                
            }
            
        }
        
        return answer;
        
    }
    
    public void dfs(int i, List<Integer>[] arr) {
        
        for (int n : arr[i]) {
            if (!visited[n]) {
                
                visited[n] = true;
                
                dfs(n, arr);
            }
        }
        
    }
}