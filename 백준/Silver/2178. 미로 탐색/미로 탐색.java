import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, result, cnt = 0;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] nums;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				nums[i][j] = s.charAt(j) - '0';
			}
		}
		
		bfs();
		
		System.out.println(result);
	}
	
	public static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0, 0});
		boolean[][] visited = new boolean[N][M];
		visited[0][0] = true;
		cnt = 1;
		
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int[] now = q.poll();
			
				for (int i = 0; i < 4; i++) {
					
					int x = now[0] + dr[i];
					int y = now[1] + dc[i];
					
					if (x == N-1 && y == M-1) {
						result = cnt + 1;
						return;
					}
					
					if (x < 0 || x >= N || y < 0 || y >= M) continue;
					if (nums[x][y] == 0) continue; 
					
					if (!visited[x][y]) {
						visited[x][y] = true;
						q.add(new int[] {x, y});
					}
				}
			}
			cnt++;
		}
	}
}
