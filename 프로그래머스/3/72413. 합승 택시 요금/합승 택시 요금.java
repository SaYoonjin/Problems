import java.util.*;

class Solution {
    
    static ArrayList<Node>[] graph;
    
    static class Node implements Comparable<Node> {
        
        int to, cost;
        
        Node (int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
        
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        // n : 지점 개수
        // fares : [c, d, f] -> c지점과 d지점 사이의 예상 택시요금이 f원
        
        // 각각 s, a, b 용 다익스트라 저장용 
        int[] dist1 = new int[n + 1];
        int[] dist2 = new int[n + 1];
        int[] dist3 = new int[n + 1];
        
        for (int i = 0; i < n + 1; i++){
            dist1[i] = Integer.MAX_VALUE;
            dist2[i] = Integer.MAX_VALUE;
            dist3[i] = Integer.MAX_VALUE;
        }
        
        // 그래프 만들기
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();
        
        for (int[] fare : fares){
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            
            graph[c].add(new Node(d, f));
            graph[d].add(new Node(c, f));
        }
        
        dijk(s, dist1);
        dijk(a, dist2);
        dijk(b, dist3);
        
        int answer = Integer.MAX_VALUE;
        
        for (int i = 1; i < n + 1; i++){
            if(dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE && dist3[i] != Integer.MAX_VALUE){
                int r = dist1[i] + dist2[i] + dist3[i];
                if (r < answer) answer = r;
            }
        }
        
        return answer;
        
    }
    
    public static void dijk(int start, int[] dist){
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()){
            Node now = pq.poll();
            
            if (dist[now.to] < now.cost) continue;
            
            for (Node next : graph[now.to]){
                int newCost = dist[now.to] + next.cost;
            
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
    }
}