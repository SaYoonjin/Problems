import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// . : 언제나 이동 가능
	// # : 절대 이동 불가능
	// a, b, ... : 열쇠, 언제나 이동 가능 
	// A, B, ... : 열쇠 있을 때만 이동 가능
	// 0 : 민식이 현재 위치
	// 1 : 탈출구
	public static class Node{
		int x, y, dist, keyMask;
		
		public Node(int x, int y, int dist, int keyMask) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.keyMask = keyMask;
		}
		
		
	}
	static int result, ar, ac, N, M;
	static char[][] CH;
	static boolean[][][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 7
		M = Integer.parseInt(st.nextToken());	// 8
		CH = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				CH[i][j] = s.charAt(j);
				if (CH[i][j] == '0') {
					ar = i;
					ac = j;
				}
			}
		}
		
		int answer = bfs();
		
		System.out.println(answer);
	}
	
	public static int bfs() {
		
		visited = new boolean[N][M][64];
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(ar, ac, 0, 0));
		visited[ar][ac][0] = true;
		
		while (!q.isEmpty()) {
			Node now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int a = now.x + dr[i];
				int b = now.y + dc[i];
				int keyMask = now.keyMask;
				
				if (a >= N || a < 0 || b >= M || b < 0) continue;
				
				char ta = CH[a][b];
				if (ta == '#') continue;
				
				if (ta >= 'a' && ta <= 'f') {
					keyMask |= (1 << (ta -'a'));
				}
				
				else if (ta >= 'A' && ta <= 'F') {
					if ((keyMask & (1 << (ta - 'A'))) == 0) continue;
				}
				
				if (!visited[a][b][keyMask]) {
					visited[a][b][keyMask] = true;
					q.add(new Node(a, b, now.dist + 1, keyMask));
				}
				if (ta == '1') return now.dist + 1;
			}
		}
		return -1;
	}
}
