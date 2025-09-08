import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken()); 
			N = Integer.parseInt(st.nextToken()); 
			
			if (N == 0 && M == 0) break;
			
			visited = new boolean[N][M];
			nums = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
					if (nums[i][j] == 1 && !visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
					
				}
			}
			System.out.println(cnt);
		}
	}

	static int N, M;
	static boolean[][] visited;
	static int[][] nums;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void bfs(int a, int b) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {a, b});
		visited[a][b] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int x = now[0] + dr[i];
				int y = now[1] + dc[i];
				
				if (x < 0 || x >= N || y < 0 || y >= M) continue;
				
				if (!visited[x][y] && nums[x][y] == 1) {
					visited[x][y] = true;
					q.offer(new int[] {x, y});
				}
			}
		}
	}
}
