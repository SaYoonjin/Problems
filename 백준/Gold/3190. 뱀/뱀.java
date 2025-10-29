import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static boolean[][] snake;
	static int rx = 0, ry = 0;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 처음 길이 : 1
		// 이동한 칸에 사과 있으면 --> 사과 없어지고 꼬리 안움직임
		// 이동한 칸에 사과 없으면 --> 몸길이 줄이고 꼬리 칸 비워줌 
		// 종료 조건 : 벽 or 자기자신의 몸과 부딪히면 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());	// 보드 크기
		int K = Integer.parseInt(br.readLine());	// 사과 개수
		int len = 1;								// 뱀 길이
		boolean[][] apple = new boolean[N+1][N+1];
		snake = new boolean[N+1][N+1];
		int[] now = {1, 1};
		snake[1][1] = true;
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			apple[a][b] = true;
		}
		
		int L = Integer.parseInt(br.readLine());
		Map<Integer, Character> map = new HashMap<>();
		
		// c == 'L' --> 왼쪽
		// c == 'D' --> 오른쪽 
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			map.put(x, c);
		}
		
		int round = 0;
		int direction = 0;
		
		int[][] tail = new int[N*N + 1][2];
		int headIdx = 0, tailIdx = 0;
		tail[0][0] = 1;
		tail[0][1] = 1;
		
		while (true) {
			
			
			now[0] = now[0] + dr[direction];
			now[1] = now[1] + dc[direction];
			
			int nx = now[0];
			int ny = now[1];
			
			if (nx < 1 || nx > N || ny < 1 || ny > N) break;
			if (snake[nx][ny]) break;
			
			snake[nx][ny] = true;
			headIdx++;
			tail[headIdx][0] = nx;
			tail[headIdx][1] = ny;
			
			
			boolean ateApple = apple[nx][ny]; 
			if (ateApple) apple[nx][ny] = false;
			else {
			    int tx = tail[tailIdx][0];
			    int ty = tail[tailIdx][1];
			    snake[tx][ty] = false;
			    tailIdx++;
			}


			
			round++;
			
			if (map.containsKey(round)) {
				char c = map.get(round);
				if (c == 'L') direction = (direction + 3) % 4;
				else direction = (direction + 1) % 4;
			}
		}

		System.out.println(round + 1);
		
	}
}
