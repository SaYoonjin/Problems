import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
		// 0 : 빈 칸
		// 1 : 벽
		// 2 : 바이러스
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] nums = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		
		backtracking(cnt, nums);
		
		System.out.println(max);
	}
	
	static int max = 0;
	
	public static void backtracking(int cnt, int[][] nums) {
		
		if (cnt == 3) {
			int safe = count(nums);
			max = Math.max(safe, max);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (nums[i][j] == 0) {
					nums[i][j] = 1;
					backtracking(cnt + 1, nums);
					nums[i][j] = 0;
				}
			}
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static int count(int[][] nums) {
		boolean[][] visited = new boolean[N][M];
		int cnt1 = 0;
		
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (nums[i][j] == 2) {
					visited[i][j] = true;
					q.add(new int[] {i, j});
				}
			}
		}
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dr[i];
				int y = now[1] + dc[i];
				
				if (x < 0 || x >= N || y < 0 || y >= M) continue;
				if (nums[x][y] == 1 || nums[x][y] == 2) continue;
				
				if (!visited[x][y]) {
					visited[x][y] = true;
					q.add(new int[] {x, y});
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (nums[i][j] == 0 && !visited[i][j]) cnt1++;
			}
		}
		return cnt1;
	}
}
