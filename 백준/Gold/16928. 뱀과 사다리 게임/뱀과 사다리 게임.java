import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dist;
	static List<int[]> nums;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dist = new int[101];
		nums = new ArrayList<>();
		
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nums.add(new int[] {a, b});
		}
		
		bfs();
		
	}
	
	public static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		dist[1] = 0;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 1; i <= 6; i++) { // 주사위
				int next = now + i;
				
				if (next > 100) continue;
				
				for (int[] x : nums) {
					if (now + i == x[0]) {
						next = x[1];
						break;
					}
				}
				
				if (next == 100) {
					System.out.println(dist[now] + 1);
					return;
				}
				
				if (dist[next] == 0) {
					dist[next] = dist[now] + 1;
					q.offer(next);
				}
			}
		}
	}
}
