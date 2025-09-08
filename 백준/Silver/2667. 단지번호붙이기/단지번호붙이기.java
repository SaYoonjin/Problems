import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static int N;
	static int[][] nums;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				nums[i][j] = s.charAt(j) - '0';
			}
		}
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (nums[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					idx++;
				}
				
			}
		}
		Collections.sort(save);
		
		System.out.println(idx);
		for (int i = 0; i < save.size(); i++) {
			System.out.println(save.get(i));
		}
	}
	
	static boolean[][] visited;
	static List<Integer> save = new ArrayList<>();
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {i, j});
		visited[i][j] = true;
		
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			for (int k = 0; k < 4; k++) {
				int x = now[0] + dr[k];
				int y = now[1] + dc[k];
				
				if (x < 0 || x >= N || y < 0 || y >= N) continue;
				if (visited[x][y]) continue;
				
				if (!visited[x][y] && nums[x][y] == 1) {
					q.add(new int[] {x, y});
					visited[x][y] = true;
					cnt++;
				}
			}
		}
		save.add(cnt);
	}
}
