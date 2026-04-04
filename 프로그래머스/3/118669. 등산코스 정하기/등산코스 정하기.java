import java.util.*;

class Solution {
    
    static int[] dist;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static boolean[] isGate, isSummit;
    
    static class Node implements Comparable<Node> {
        
        int to, cost;
        
        Node (int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
        
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        // 지점 : 출입구, 쉼터, 산봉우리
        // 양방향
        // intensity : 휴식 없이 가장 긴 시간
        // 산봉우리 한 곳만 방문 후 다시 원래 출입구
        
        // n : 노드 개수
        // paths : 등산로 
        // gates : 출입구 
        // summits : 산봉우리 
        
        // 출력 : [최소 등산코드 산봉우리 번호, intensity 최소]
        
        
        // 초기 설정 & 그래프 그리기
        dist = new int[n + 1];
        graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < paths.length; i++) {
            int a = paths[i][0];
            int b = paths[i][1];
            int c = paths[i][2];
            
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        
        isGate = new boolean[n + 1];
        isSummit = new boolean[n + 1];
        
        for (int gate : gates) {
            pq.add(new Node(gate, 0));
            dist[gate] = 0;
            isGate[gate] = true;
        }
        
        for (int summit : summits) {
            isSummit[summit] = true;
        }
        
        dijkstra ();
        
        Arrays.sort(summits);
        int[] answer = new int[2];
        answer[1] = Integer.MAX_VALUE;
        
        for (int summit : summits) {
            if (answer[1] > dist[summit]) {
                answer[1] = dist[summit];
                answer[0] = summit;
            }
        }
        
        return answer;
        
    }
    
    public static void dijkstra () {
        
        while (!pq.isEmpty()) {
            
            Node now = pq.poll();
            
            if (isSummit[now.to]) continue;
            
            if (now.cost > dist[now.to]) continue;
            
            for (Node next : graph[now.to]) {
                
                if (isGate[next.to]) continue;
                
                int newCost = Math.max(now.cost, next.cost);
                
                if (dist[next.to] > newCost) {
                    dist[next.to] = newCost;
                    pq.add(new Node(next.to, newCost));
                }
                
            }
            
        }
        
    }
}