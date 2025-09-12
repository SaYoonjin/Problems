import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, idx, min = Integer.MAX_VALUE, n;
	static boolean[][] visited;
	static int[][] nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		idx = 1;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && nums[i][j] != 0) {
					label(i, j);
					idx++;
				}
			}
		}
		
		for (int k = 1; k < idx; k++) {
			n = k;
			q = new ArrayDeque<>();
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (nums[i][j] == k) {
						q.offer(new int[] {i, j});
					}
				}
			}
			bfs();
			if (find) {
				if (min > level-1) min = level;
				find = false;
			}
		}
		
		System.out.println(min);
		
	}
	
	static boolean find;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void label(int a, int b) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {a, b});
		visited[a][b] = true;
		nums[a][b] = idx;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dr[i];
				int y = now[1] + dc[i];
				
				if (x < 0 || x >= N || y < 0 || y >= N) continue;
				
				if (!visited[x][y] && nums[x][y] != 0) {
					visited[x][y] = true;
					nums[x][y] = idx;
					q.offer(new int[] {x, y});
				}
			}
		}
	}
	
	static Queue<int[]> q;
	static int level;
	
	public static void bfs() {
		// find / min 업데이트 
		
		level = 0;
		while (!q.isEmpty()) {
			
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int[] now = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int x = now[0] + dr[i];
					int y = now[1] + dc[i];
					
					if (x < 0 || x >= N || y < 0 || y >= N) continue;
					
					if (nums[x][y] != 0 && nums[x][y] != n) {
						find = true;
						return;
					}
					
					if (!visited[x][y] && nums[x][y] == 0) {
						visited[x][y] = true;
						q.offer(new int[] {x, y});
					}
				}
			}
			level++;
		}
	}
}
