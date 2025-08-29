import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] nums, dist;
	static int result, r, c, N;
	static int size = 2;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
				if (nums[i][j] == 9) {
					r = i;
					c = j;
					nums[i][j] = 0;
				}
			}
		}
		
		int cnt = 0;
		result = 0;
		
		while (true) {
			int di = bfs();
			if (di == 0) {
				break;
			}
			
			else {
				result += di;
				cnt++;
				if (size == cnt) {
					size++;
					cnt = 0;
				}
			}
		}
		System.out.println(result);
	}
	
	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] check = new boolean[N][N];
		
		int[][] dist = new int[N][N];
		for (int i = 0; i < dist.length; i++) {
			for (int j = 0; j < dist.length; j++) {
				dist[i][j] = -1;
			}
		}
		
		q.add(new int[] {r, c});
		check[r][c] = true;
		dist[r][c] = 0;
		
		List<int[]> fish = new ArrayList<>();
		
		int min = Integer.MAX_VALUE;
		int tax = r;
		int tay = c;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int d = dist[r][c] + 1;
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if (nums[nr][nc] > size) continue;
				if (check[nr][nc]) continue;
				
				check[nr][nc] = true;
				dist[nr][nc] = dist[r][c] + 1;
				
				if (nums[nr][nc] < size && nums[nr][nc] > 0) {
					fish.add(new int[] {nr, nc, dist[nr][nc]} );
				}
				q.add(new int[] {nr, nc});
			}
		}
		if (fish.isEmpty()) return 0;
		
		fish.sort((a, b) -> {
			if (a[2] != b[2]) return a[2] - b[2];
			if (a[0] != b[0]) return a[0] - b[0];
			else return a[1] - b[1];
		});
		
		int[] target = fish.get(0);
		r = target[0];
		c = target[1];
		nums[r][c] = 0;
		return target[2];
	}
}
