import java.util.*;

class Solution {
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        
        visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()){
            int[] now = q.poll();
            
            for (int i = 0; i < 4; i++){
                int x = now[0] + dr[i];
                int y = now[1] + dc[i];
                
                if (x == maps.length-1 && y == maps[0].length-1) {
                    return maps[now[0]][now[1]] + 1;
                }
                
                if (x < 0 || y < 0 || x >= maps.length || y >= maps[0].length) continue;
                
                if (!visited[x][y]) {
                    if (maps[x][y] == 1){
                        maps[x][y] = maps[now[0]][now[1]] + 1;
                        visited[x][y] = true;
                        q.offer(new int[]{x, y});
                    }
                }
                
                
            }
        }
        
        return -1;
    }
}