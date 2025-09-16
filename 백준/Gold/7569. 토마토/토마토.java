import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, H;
	static int[][][] nums;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		nums = new int[H][N][M];
		q = new ArrayDeque<>();
		
		for (int h = 0; h < H; h++) {
		    for (int i = 0; i < N; i++) {
		        st = new StringTokenizer(br.readLine(), " ");
		        for (int j = 0; j < M; j++) {
		            nums[h][i][j] = Integer.parseInt(st.nextToken());
		            if (nums[h][i][j] == 1) q.offer(new int[] {h, i, j});
		        }
		    }
		}
		
		bfs();
		
		boolean flag = true;
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (nums[h][i][j] == 0) flag = false;
				}
			}
		}
		
		if (!flag) System.out.println(-1);
		else System.out.println(result-1);
		
	}
	
	static int result = 0;
	static Queue<int[]> q;
	static int[] dr = {-1, 0, 1, 0, 0, 0};
	static int[] dc = {0, 1, 0, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	
	public static void bfs() {
		
		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int s = 0; s < size; s++) {
				int[] now = q.poll();
				
				for (int i = 0; i < 6; i++) {
					int h = now[0] + dh[i];
					int x = now[1] + dr[i];
					int y = now[2] + dc[i];
					
					if (x < 0 || x >= N || y < 0 || y >= M || h < 0 || h >= H) continue;
					if (nums[h][x][y] == -1) continue;
					
					if (nums[h][x][y] == 0) {
						nums[h][x][y] = 1;
						q.offer(new int[] {h, x, y});
					}
				}
			}
			result++;
		}
	}
}
