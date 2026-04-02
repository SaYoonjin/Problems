import java.util.*;

class Solution {
    
    static class Node implements Comparable<Node> {
        int to, cost;
        
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        // 비용이 작은 노드부터 나온다
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    
    public int solution(int N, int[][] road, int K){
        
        ArrayList<Node>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r : road){
            int a = r[0];
            int b = r[1];
            int c = r[2];
            
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.offer(new Node(1, 0));
        dist[1] = 0;
        
        while (!pq.isEmpty()){
            Node now = pq.poll();
            
            if (dist[now.to] < now.cost) continue;
            
            for (Node next : graph[now.to]) {
                
                int newCost = dist[now.to] + next.cost;
                
                if (newCost < dist[next.to]){
                    dist[next.to] = newCost;
                    pq.offer(new Node(next.to, newCost));
                }
            }
        }
        int answer = 0;
        
        for (int i = 1; i <= N; i++){
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
    
}