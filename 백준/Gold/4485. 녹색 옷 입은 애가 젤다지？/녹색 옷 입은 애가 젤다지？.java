import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		int x, y, w;

		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	
	static int N;
	static int[][] nums, dist;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0 ,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		int idx = 1;
		
		while (N != 0) {
			sb.append("Problem " + idx + ": ");
			idx++;
			
			nums = new int[N][N];
			dist = new int[N][N];
		
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			dist[0][0] = nums[0][0];
			sb.append(di()).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		System.out.println(sb);
	}
	
	public static int di() {
		PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
		q.add(new Node(0, 0, nums[0][0]));
		
		while (!q.isEmpty()) {
			Node now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int ax = dr[i] + now.x;
				int ay = dc[i] + now.y;
				
				if (ax < 0 || ax >= N || ay < 0 || ay >= N) continue;
				
				if (dist[ax][ay] > dist[now.x][now.y] + nums[ax][ay]) {
					dist[ax][ay] = dist[now.x][now.y] + nums[ax][ay];
					q.add(new Node(ax, ay, dist[ax][ay]));
				}
			}
		}
		return dist[N-1][N-1];
	}
}
