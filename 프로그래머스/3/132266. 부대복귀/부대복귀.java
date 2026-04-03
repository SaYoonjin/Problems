import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        // n : 총 지역 수
        // roads : 길 정보 
        // sources : 각 부대원이 위치한 지역들 
        // destination : 강철부대 지역 
        
        int[] dist = new int[n+1];
        List<Integer>[] map = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++){
            map[i] = new ArrayList<>();
            dist[i] = -1;
        }
        
        for (int[] r : roads){
            int a = r[0];
            int b = r[1];
            map[a].add(b);
            map[b].add(a);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(destination);
        dist[destination] = 0;
        
        while (!q.isEmpty()){
            int now = q.poll();
            
            for (int x : map[now]){
                if (dist[x] == -1) {
                    dist[x] = dist[now] + 1;
                    q.offer(x);
                }
            }
        }
        
        int[] answer = new int[sources.length];
        int idx = 0;
        for (int x : sources){
            answer[idx++] = dist[x];
        }
        return answer;
    }
}