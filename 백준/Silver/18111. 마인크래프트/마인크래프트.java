import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 블록 제거 2초
		// 블록 넣기 1초
		// 높이 <= 256
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int min = 0, max = 256;
		
		 for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine());
	            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max, map[i][j]);
	            }
		 }
		 
		int result = Integer.MAX_VALUE;
		int rh = 0;
		for (int i = min; i <= max; i++) {
			int remove = 0, add = 0;
			
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					int d = map[j][j2] - i;
					if (d > 0) remove += d;
					else add -= d;
				}
			}
			if (remove + B >= add) {
				int time = remove * 2 + add;
				if (time <= result) {
					result = time;
					rh = i;
				}
			}
		}
		System.out.println(result + " " + rh);
	}
}
