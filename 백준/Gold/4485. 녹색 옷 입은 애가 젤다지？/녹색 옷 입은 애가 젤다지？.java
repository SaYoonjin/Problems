import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] dist;
	static int[][] nums;
	static boolean[][] visited;
	static Deque<Node> n;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = 1;
		N = Integer.parseInt(br.readLine());

		while (true) {

			n = new ArrayDeque<Node>();

			dist = new int[N][N];
			nums = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					dist[i][j] = Integer.MAX_VALUE;
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dist[0][0] = nums[0][0];

			int result = d(0, 0);

			sb.append("Problem ").append(tc++).append(": ").append(result).append("\n");

			N = Integer.parseInt(br.readLine());
			if (N == 0) break;
		}
		System.out.println(sb);
	}

	public static int d(int x, int y) {
		n.offer(new Node(x, y));

		if (!visited[x][y]) visited[x][y] = true;

		while (!n.isEmpty()) {
			Node now = n.poll();

			int a = now.x;
			int b = now.y;

			for (int i = 0; i < 4; i++) {
				int xx = a + dx[i];
				int yy = b + dy[i];

				if (xx < 0 || xx >= N || yy < 0 || yy >= N)
					continue;

				else {
					if (dist[xx][yy] > dist[a][b] + nums[xx][yy]) {
						dist[xx][yy] = dist[a][b] + nums[xx][yy];
						n.offer(new Node(xx, yy));
					}
				}
			}
		}
		return dist[N - 1][N - 1];
	}

	public static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
    }
}
