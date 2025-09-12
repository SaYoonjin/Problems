import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map, dist;
	static int INF = 10000001;
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 죽음의 구역 : 들어갈 수 없음
		// 위험한 구역 : 한 번 움직일 때마다 생명 1씩 감소
		// 안전한 구역 
		// 0, 0 ---> 500, 500, 4방
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[501][501];
		visited = new boolean[501][501];
		
		dist = new int[501][501];
		for (int i = 0; i < 501; i++) {
			for (int j = 0; j < 501; j++) dist[i][j] = INF;
		}
		
		int warn = Integer.parseInt(br.readLine());
		if (warn != 0) {
			for (int i = 0; i < warn; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				
				int sx = Math.min(x1, x2);
				int sy = Math.min(y1, y2);
				int lx = Math.max(x1, x2);
				int ly = Math.max(y1, y2);
				
				for (int j = sx; j <= lx; j++) {
					for (int j2 = sy; j2 <= ly; j2++) {
						map[j][j2] = 1;
					}
				}
			}
		}
		
		int death = Integer.parseInt(br.readLine());
		if (death != 0) {
			for (int i = 0; i < death; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				
				int sx = Math.min(x1, x2);
				int sy = Math.min(y1, y2);
				int lx = Math.max(x1, x2);
				int ly = Math.max(y1, y2);
				
				for (int j = sx; j <= lx; j++) {
					for (int j2 = sy; j2 <= ly; j2++) {
						visited[j][j2] = true;
					}
				}
			}
		}
		
		map[0][0] = 0;
		visited[0][0] = false;
		dist[0][0] = 0;
		
		dijk();
		
		if (dist[500][500] == INF) System.out.println(-1);
		else System.out.println(dist[500][500]);
		
	}
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void dijk() {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		pq.offer(new int[] {0, 0, dist[0][0]});
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = dr[i] + now[0];
				int y = dc[i] + now[1];
				
				if (x < 0 || x >= 501 || y < 0 || y >= 501) continue;
				if (visited[x][y]) continue;
				
				if (dist[x][y] > dist[now[0]][now[1]] + map[x][y]) {
					dist[x][y] = dist[now[0]][now[1]] + map[x][y];
					pq.offer(new int[] {x, y, dist[x][y]});
				}
			}
		}
	}
}
