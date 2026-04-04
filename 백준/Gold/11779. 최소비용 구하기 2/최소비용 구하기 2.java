import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] dist, prev;
    static ArrayList<Node>[] graph;
    static int destination, start;
    static List<Integer> answer;

    static class Node implements Comparable<Node>{

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

    public static void main(String[] args) throws IOException {

        // A -> B
        // 최소비용과 경로 출력

        // 입력
        // n = 도시 개수, m = 버스의 개수
        // 버스 정보(도착지의 도시 번호, 버스 비용)
        // 출발점, 도착점

        // 출력
        // 최소 버스 비용
        // 도시의 개수
        // 경로 (여러 개면 아무거나 하나)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        answer = new ArrayList<>();
        prev = new int[n + 1];
        graph = new ArrayList[n + 1];
        dist = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        // 그래프 만들기
        for (int i = 0; i < m; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());

        dijkstra(start);
        sb.append(dist[destination]).append("\n");

        path(start, destination, prev);
        sb.append(answer.size()).append("\n");
        for (int i = answer.size() - 1; i >= 0 ; i--) {
            sb.append(answer.get(i)).append(" ");
        }

        System.out.println(sb);

    }

    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (dist[now.to] < now.cost) continue;

            for (Node next : graph[now.to]){
                int newCost = dist[now.to] + next.cost;

                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    prev[next.to] = now.to;
                    pq.offer(new Node(next.to, newCost));
                }

            }

        }

    }

    public static void path(int start, int destination, int[] prev){

        int now = destination;

        while (true) {

            answer.add(now);

            if (now == start) break;

            now = prev[now];

        }

    }

}
