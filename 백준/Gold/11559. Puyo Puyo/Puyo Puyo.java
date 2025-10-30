import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] map = new char[12][6];

		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		while (true) {
			ex = false;
			bfs(map);
			if (!ex)
				break;
			down(map);
			result++;
		}
		
		System.out.println(result);

	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean ex;

	public static void bfs(char[][] map) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[12][6];

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] != '.' && !visited[i][j]) {

					List<int[]> list = new ArrayList<>();
					char color = map[i][j];

					visited[i][j] = true;
					q.offer(new int[] { i, j });
					list.add(new int[] { i, j });

					while (!q.isEmpty()) {

						int[] now = q.poll();
						int r = now[0];
						int c = now[1];

						for (int k = 0; k < 4; k++) {
							int x = r + dr[k];
							int y = c + dc[k];

							if (x < 0 || x >= 12 || y < 0 || y >= 6)
								continue;

							if (map[x][y] == color && !visited[x][y]) {
								visited[x][y] = true;
								q.offer(new int[] { x, y });
								list.add(new int[] { x, y });
							}
						}
					}

					if (list.size() >= 4) {
						for (int[] arr : list) {
							map[arr[0]][arr[1]] = '.';
						}
						ex = true;
					}
				}
			}
		}

	}

	public static void down(char[][] map) {
		for (int i = 0; i < 6; i++) {
			Queue<Character> q = new ArrayDeque<>();

			for (int j = 11; j >= 0; j--) {
				if (map[j][i] != '.') {
					q.offer(map[j][i]);
					map[j][i] = '.';
				}
			}

			int idx = 11;
			while (!q.isEmpty()) {
				map[idx--][i] = q.poll();
			}
		}
	}
}
