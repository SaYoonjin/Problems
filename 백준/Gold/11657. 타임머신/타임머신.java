import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	// V-1번 반복하면서 최단 거리 갱신 -> 일반적인 답
	// 이후 간선 개수만큼 돌면서 음수 사이클 확인
	
	public static class Edge{
		int from;
		int to;
		int cost;
		
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	static long[] dist;
	static List<Edge> elist;
	static boolean cycle;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		elist = new ArrayList<Edge>();
		
		dist = new long[N+1];
		for (int i = 0; i < dist.length; i++) dist[i] = Long.MAX_VALUE;
		dist[1] = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			elist.add(new Edge(a, b, c));
		}
		
		bell(N, M);
		
	}
	
	public static void bell(int v, int e) {
		
		for (int i = 0; i < v-1; i++) {
			for (int j = 0; j < e; j++) {
				Edge now = elist.get(j);
				
				if (dist[now.from] != Long.MAX_VALUE && dist[now.to] > dist[now.from] + now.cost) {
					dist[now.to] = dist[now.from] + now.cost;
				}
			}
		}
		
		for (int i = 0; i < e; i++) {
			Edge edge = elist.get(i);
			
			if (dist[edge.from] != Long.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.cost) {
				cycle = true;
			}
		}
		if (cycle) {
			System.out.println(-1);
		}
		else {
			for (int i = 2; i < dist.length; i++) {
				if (dist[i] == Long.MAX_VALUE) System.out.println(-1);
				else System.out.println(dist[i]);
			}
		}
	}
}
