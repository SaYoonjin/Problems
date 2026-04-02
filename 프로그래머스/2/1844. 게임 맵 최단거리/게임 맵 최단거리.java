import java.util.*;

class Solution {
    
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        
        visited = new boolean[maps.length][maps[0].length]; // 5 x 5
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        maps[0][0] = 1;
        
        while (!q.isEmpty()){
            int[] now = q.poll();
            
            if (now[0] == maps.length-1 && now[1] == maps[0].length-1) {
                return maps[now[0]][now[1]];
            }
                        
            for (int i = 0; i < 4; i++){
                int x = now[0] + dr[i];
                int y = now[1] + dc[i];
                
                if (x < 0 || y < 0 || x >= maps.length || y >= maps[0].length) continue;
                
                if (!visited[x][y] && maps[x][y] == 1){
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                    maps[x][y] = maps[now[0]][now[1]] + 1;
                }
            }
        }
        
        return -1;
    }
}