import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] nums = new int[2][N];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] result = new int[N][3];
			
			result[0][0] = nums[0][0];
			result[0][1] = nums[1][0];
			result[0][2] = 0;
			
			if (N > 1) {
				for (int i = 1; i < N; i++) {
					result[i][0] = nums[0][i] + Math.max(result[i-1][1], result[i-1][2]);
					result[i][1] = nums[1][i] + Math.max(result[i-1][0], result[i-1][2]);
					result[i][2] = Math.max(result[i-1][0], Math.max(result[i-1][1], result[i-1][2]));
				}
			}
			
			System.out.println(Math.max(result[N-1][0], Math.max(result[N-1][1], result[N-1][2])));
			
		}
	}
}
