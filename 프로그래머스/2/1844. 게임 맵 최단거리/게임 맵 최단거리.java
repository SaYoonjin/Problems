import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(int[][] maps) {
        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        answer = -1;
        
        bfs(visited, maps);
        
        return answer;
        
    }
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public static void bfs(boolean[][] visited, int[][] maps) {
        
        Queue<int[]> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.offer(new int[] {0, 0});
        int cnt = 1;
        
        while (!q.isEmpty()) {
            
            int size = q.size();
            
            for (int s = 0; s < size; s++) {
            
                int[] now = q.poll();
                
                for (int i = 0; i < 4; i++) {

                    int x = now[0] + dr[i];
                    int y = now[1] + dc[i];

                    if (x == maps.length - 1 && y == maps[0].length - 1) {
                        answer = cnt + 1;
                        return;
                    }

                    if (x < 0 || y < 0 || x >= maps.length || y >= maps[0].length) continue;

                    if (!visited[x][y] && maps[x][y] == 1) {
                        visited[x][y] = true;
                        q.offer(new int[] {x, y});
                    }
                }
            }
            cnt++;
            
        }
        
    }
}