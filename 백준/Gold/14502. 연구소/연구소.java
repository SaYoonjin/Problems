import java.io.*;
import java.util.*;

public class Main {
	
	static int max = 0, N, M;
	static int[][] nums;
	
	public static void main(String[] args) throws IOException {
		
		// 0 : 빈 칸
		// 1 : 벽
		// 2 : 바이러스가 있는 곳
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, nums);
		
		System.out.println(max);
		
	}
	
	public static void dfs(int cnt, int[][] nums) {
		
		if (cnt == 3) {
			 int result = count(nums);
			 if (result > max) max = result;
			 return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (nums[i][j] == 0) {
					nums[i][j] = 1;
					dfs(cnt + 1, nums);
					nums[i][j] = 0;
				}
			}
		}
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static int count(int[][] nums) {
		
		int[][] copy = new int[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = nums[i][j];
				if (copy[i][j] == 2) q.offer(new int[] {i, j});
			}
		}
		
		int c = 0;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dr[i];
				int y = now[1] + dc[i];
				
				if (x < 0 || x >= N || y < 0 || y >= M) continue;
				
				if (copy[x][y] == 0) {
					copy[x][y] = 2;
					q.offer(new int[] {x, y});
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0) c++;
			}
		}
		return c;
	}
}
