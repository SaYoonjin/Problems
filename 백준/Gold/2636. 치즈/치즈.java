import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] nums;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		
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
	
		int result = 0;
		
		while (true) {
			visited = new boolean[N][M];
			
			cnt = bfs();
			if (cnt == 0) {
				break;
			}
			
			time++;
			result = cnt;
		}
		
		System.out.println(time);
		System.out.println(result);
		
	}
	static int time = 0, cnt;
	
	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0, 0});
		visited[0][0] = true;
		
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dr[i];
				int y = now[1] + dc[i];
				
				if (x < 0 || x >= N || y < 0 || y >= M) continue;
				
				if (nums[x][y] == 1) {
					nums[x][y] = 0;
					visited[x][y] = true;
					cnt++;
				}
				else if (visited[x][y] == false) {
					visited[x][y] = true;
					q.add(new int[] {x, y});
				}
			}
		}
		return cnt;
	}
}
