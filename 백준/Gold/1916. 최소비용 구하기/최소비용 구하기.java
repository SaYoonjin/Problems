import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, start, end;
	static int[] dist;
	static List<int[]>[] nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// N : 도시 / M : 버스
		// 버스 출발 도시, 도착 도시, 비용
		// 출발 - 목적지
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		nums = new ArrayList[N+1];
		dist = new int[N+1];
		for (int i = 0; i < dist.length; i++) dist[i] = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) nums[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			nums[a].add(new int[] {b, w});
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		cal();
		
	}
	
	public static void cal() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1])); //가중치 기준 정렬
		pq.add(new int[] {start, 0});
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int node = now[0];
			int cost = now[1];
			
			if (cost > dist[node]) continue;
			
			for (int[] next : nums[node]) {
				int nn = next[0];
				int nc = next[1];
				
				if (dist[nn] > cost + nc) {
					dist[nn] = cost + nc;
					pq.add(new int[] {nn, dist[nn]});
				}
			}
		}
		System.out.println(dist[end]);
	}
}
