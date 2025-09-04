import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] map;
	static int ax, ay, N, M, result = 0;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] visited;
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		// 0 : 빈 공간
		// x : 벽
		// I : 도연이
		// P : 사람 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'I') {
					ax = i;
					ay = j;
				}
			}
		}
		
		bfs();
		
		if (flag) System.out.println(result);
		else System.out.println("TT");
		
	}
	
	public static void bfs() {
		
		Queue<int[]> q = new ArrayDeque<int[]>();
		q.add(new int[] {ax, ay});
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = dr[i] + now[0];
				int y = dc[i] + now[1];
				
				if (x >= N || x < 0 || y >= M || y < 0) continue;
				if (map[x][y] == 'X') continue;
				
				if (!visited[x][y]) {
					visited[x][y] = true;
					
					if (map[x][y] == 'P') {
						flag = true;
						cnt++;
					}
					q.add(new int[] {x, y});
				}
			}
		}
		result = cnt;
	}
}
