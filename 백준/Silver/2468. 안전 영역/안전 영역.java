import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int result = 0, N;
	static boolean[][] visited;
	static int[][] nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N][N];
		
		int mh = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
				if (nums[i][j] > mh) mh = nums[i][j];
			}
		}
		
		int max = 0;
		
		for (int h = 0; h < mh; h++) {
			visited = new boolean[N][N];
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (nums[i][j] <= h) visited[i][j] = true;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			if (max < cnt) max = cnt;
		}
		
		System.out.println(max);
		
	}

	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void bfs(int a, int b) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {a, b});
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			visited[now[0]][now[1]] = true;
			
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dr[i];
				int y = now[1] + dc[i];
				
				if (x < 0 || x >= N || y < 0 || y >= N) continue;
				
				if (!visited[x][y]) {
					visited[x][y] = true;
					q.offer(new int[] {x, y});
				}
			}
		}
	}
}
