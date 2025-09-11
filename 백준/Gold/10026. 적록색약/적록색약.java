import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int N;
	static char[][] color;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		color = new char[N][N];
		
		for (int i = 0; i < color.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < color.length; j++) {
				color[i][j] = s.charAt(j);
			}
		}
		
		int cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < color.length; i++) {
			for (int j = 0; j < color.length; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt + " ");
		
		
		//G 아니면 B로
		for (int i = 0; i < color.length; i++) { 
			for (int j = 0; j < color.length; j++) {
				if (color[i][j] == 'R') color[i][j] = 'G';
			}
		}
		cnt = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < color.length; i++) {
			for (int j = 0; j < color.length; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		
		System.out.println(sb);
	}
	
	public static void bfs(int a, int b) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {a, b});
		visited[a][b] = true;
		
		while (!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = now[0] + dr[i];
				int y = now[1] + dc[i];
				
				if (x < 0 || x >= N || y < 0 || y >= N) continue;
				
				if (!visited[x][y] && color[now[0]][now[1]] == color[x][y]) {
					visited[x][y] = true;
					q.offer(new int[] {x, y});
				}
			}
		}
	}
}
