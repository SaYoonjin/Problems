import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] nums, dist;
	static int result, N;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int round = 1;
		
		while (true) {
			N = Integer.parseInt(br.readLine());
			
			if (N == 0) break;
			
			sb.append("Problem " + round + ": ");
			round ++ ;
			
			nums = new int[N][N];
			dist = new int[N][N];
			result = 0;
			
			for (int i = 0; i < nums.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < nums.length; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			dijk(0, 0);
			
			result = dist[N-1][N-1];
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
		
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static public void dijk(int a, int b) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[2]));
		pq.offer(new int[] {a, b, nums[0][0]});
		dist[0][0] = nums[0][0];
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dr[i];
				int y = now[1] + dc[i];
				
				if (x < 0 || x >= N || y < 0 || y >= N) continue;
				
				if (dist[now[0]][now[1]] + nums[x][y] < dist[x][y]) {
					dist[x][y] = dist[now[0]][now[1]] + nums[x][y];
					pq.offer(new int[] {x, y, dist[x][y]});
				}
			}
		}
	}
}
