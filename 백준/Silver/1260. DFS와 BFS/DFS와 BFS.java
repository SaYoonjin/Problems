
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	private static List<Integer>[] nd;
	private static boolean[] check_dfs;
	private static int result = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken()); // 정점 개수
		int M = Integer.parseInt(st.nextToken()); // 간선 개수
		int V = Integer.parseInt(st.nextToken()); // 시작 정점 
		
		nd = new ArrayList[N+1];
		
		for (int i = 0; i <= N; i++) {
			nd[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nd[a].add(b);
			nd[b].add(a);
		}
		
		for (int i = 1; i < N+1; i++) {
			Collections.sort(nd[i]);
		}
		
		//DFS
		check_dfs = new boolean[N+1];
		dfs(V);
		
		
		//BFS
		boolean[] check_bfs = new boolean[N+1];
		Queue<Integer> q = new LinkedList<>();
//		int[] dist = new int[N+1];
		
		check_bfs[V] = true;
		q.add(V);
//		dist[V] = 0; //거리 구하려면 이렇게 
		sb.append("\n");
		while (!q.isEmpty()) {
			int a = q.poll();
			sb.append(a).append(" ");
			
			for (int n : nd[a]) {
				if (!check_bfs[n]) {
					check_bfs[n] = true;
					q.add(n);
//					dist[n] = dist[a] + 1;
				}
			}
		}
		System.out.println(sb);
		
		
		
	}
	public static void dfs(int a) {
		
		check_dfs[a] = true;
		sb.append(a).append(" ");
		
		for (int b : nd[a]) {
			if (!check_dfs[b]) dfs(b);
		}
	}
}
