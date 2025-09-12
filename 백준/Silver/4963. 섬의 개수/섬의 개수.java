import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int w, h;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static boolean[][] visited;
	static int[][] nums;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if (w == 0 && h == 0) break;
			
			nums = new int[h][w];
			visited = new boolean[h][w];
			
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < w; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && nums[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
		
	}
	
	public static void bfs(int a, int b) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {a, b});
		visited[a][b] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 8; i++) {
				int x = dr[i] + now[0];
				int y = dc[i] + now[1];
				
				if (x < 0 || x >= h || y < 0 || y >= w) continue;
				
				if (!visited[x][y] && nums[x][y] == 1) {
					visited[x][y] = true;
					q.offer(new int[] {x, y});
				}
			}
		}
	}
}
