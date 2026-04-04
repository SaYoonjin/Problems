import java.util.*;

class Solution {
    
    static int[] dist;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    
    static class Node implements Comparable<Node> {
        
        int to, cost;
        
        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
        
    }
    
    public int solution(int N, int[][] road, int K) {
        
        // N : 마을 개수
        // road : 도로 정보
        // 음식 배달 가능 시간 : K
        
        // 출력 : 마을 개수
        
        
        // 초기 설정 (dist, PriorityQueue)
        dist = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        // 그래프 그리기
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        
        dijkstra();
        
        int answer = 0;
        
        for (int i = 1; i < N + 1; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
        
    }
    
    public static void dijkstra() {
        
        pq.offer(new Node(1, 0));
        dist[1] = 0;
        
        while (!pq.isEmpty()) {
            
            Node now = pq.poll();
            
            if (dist[now.to] < now.cost) continue;
            
            for (Node next : graph[now.to]) {
                
                int newCost = dist[now.to] + next.cost;
                
                if (dist[next.to] > newCost) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
                
            }
            
        }
        
    }
}