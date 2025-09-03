import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] visited;
	static int[][] nums, dist;
	static int ax = 0, ay = 0, N, M;	// 목표지점
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int a = Integer.parseInt(st.nextToken());
				nums[i][j] = a;
				if (a == 2) {
					ax = i;
					ay = j;
					dist[i][j] = 0;
					visited[i][j] = true;
				}
				else if (a == 0) {
					dist[i][j] = 0;
					visited[i][j] = true;
				}
				else dist[i][j] = -1;
			}
		}
		
		bfs();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[]{ax, ay, 0});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int rr = dr[i] + now[0];
				int cc = dc[i] + now[1];
				
				if (rr >= N || rr < 0 || cc >= M || cc < 0) continue;
				
				if (!visited[rr][cc]) {
					visited[rr][cc] = true;
					dist[rr][cc] = now[2] + 1;
					q.add(new int[] {rr, cc, now[2] + 1});
				}
			}
		}
	}
}
