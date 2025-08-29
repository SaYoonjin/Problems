import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

	static int N;
	static int[][] nums;
	static int[][] dist;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");

			N = Integer.parseInt(br.readLine());
			nums = new int[N][N];
			dist = new int[N][N];

			for (int i = 0; i < dist.length; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			dist[0][0] = nums[0][0];
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
				    nums[i][j] = line.charAt(j) - '0';
				}
			}
			
			int result = dik();

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static int dik() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.offer(new int[] {0, 0, 0});
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int x = now[0];
			int y = now[1];
			int w = now[2];
			
			if (x == N-1 && y == N-1) return w;
			
			if (w > dist[x][y]) continue; // 이미 더 작은 값이 저장돼있으면 패스
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
				
				int neww = w + nums[x][y];
				if (neww < dist[nx][ny]) {
					dist[nx][ny] = neww;
					pq.offer(new int[] {nx, ny, neww});
				}
			}
		}
		return -1;
	}
}
