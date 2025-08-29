import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());	// 7
		int C = Integer.parseInt(st.nextToken());	// 8
		int T = Integer.parseInt(st.nextToken());	// 2
		int[][] nums = new int[R][C];
		int[][] temp = new int[R][C];
		int ac = 0;
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
				if (nums[i][j] == -1) {
					ac = i; 	// 공기청정기 행 값
					nums[i][j] = 0;
				}
			}
		}
		ac -= 1;
		
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		for (int t = 0; t < T; t++) {
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (nums[i][j] != 0 && nums[i][j] != -1) {
						int now = nums[i][j];
						int spread = now / 5;
						int cnt = 0;
						
						for (int k = 0; k < 4; k++) {
							int nx = i + dr[k];
							int ny = j + dc[k];
							
							if (nx >= R || nx < 0 || ny >= C || ny < 0) continue;
						
							if (nx == ac && ny == 0) continue;
							if (nx == ac+1 && ny == 0) continue;
							
							temp[nx][ny] += spread;
							cnt++;
						}
						nums[i][j] -= cnt * spread;
					}
				}
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					nums[i][j] += temp[i][j];
					temp[i][j] = 0;
				}
			}
			for (int i = ac-1; i > 0; i--) nums[i][0] = nums[i-1][0];
			for (int i = 0; i < C-1; i++) nums[0][i] = nums[0][i+1];
			for (int i = 0; i < ac; i++) nums[i][C-1] = nums[i+1][C-1];
			for (int i = C-1; i > 0; i--) nums[ac][i] = nums[ac][i-1];
			nums[ac][1] = 0;
			
			int ab = ac + 1;
			for (int i = ab + 1; i < R-1; i++) nums[i][0] = nums[i+1][0];
			for (int j = 0; j < C-1; j++) nums[R-1][j] = nums[R-1][j+1];
			for (int i = R-1; i > ab; i--) nums[i][C-1] = nums[i-1][C-1];
			for (int j = C-1; j > 1; j--) nums[ab][j] = nums[ab][j-1];
			nums[ab][1] = 0;
		}
		
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += nums[i][j];
			}
		}
		System.out.println(result);
	}
}
