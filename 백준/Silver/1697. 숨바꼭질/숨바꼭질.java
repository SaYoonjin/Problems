import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int cnt, N, M;
	
	public static void main(String[] args) throws IOException {
		// x-1 / x+1 / 2*x
		// 5 17
		// 4
		// 5 -> 10 -> 9 -> 18 -> 17
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		
		bfs();
		
		System.out.println(cnt);
		
	}
	static Queue<Integer> q;
	static boolean[] visited;
	
	public static void bfs() {
		q = new ArrayDeque<>();
		q.add(N);
		visited[N] = true;
		cnt = 0;
		
		while (!q.isEmpty()) {
			int size = q.size();
			int now = 0;
			
			for (int i = 0; i < size; i++) {
				now = q.poll();
				
				if (now == M) return;
			
				if (now + 1 < 100000 && !visited[now + 1]) {
					visited[now + 1] = true;
					q.add(now + 1);
				}
				if (now - 1 >= 0 && !visited[now-1]) {
					visited[now - 1] = true;
					q.add(now - 1);
				}
				if (now * 2 <= 100000 && !visited[now * 2]) {
					visited[now * 2] = true;
					q.add(now * 2);
				}
			}
			cnt++;
		}
	}
}
