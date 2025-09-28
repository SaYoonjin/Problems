import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] nums = new int[N][N];
		int[][] result = new int[N][N];
		
		for (int i = 0; i < result.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result[0][0] = nums[0][0];
		
		for (int i = 1; i < result.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == i) result[i][j] = result[i-1][j-1] + nums[i][j];
				else if (j == 0) result[i][j] = result[i-1][j] + nums[i][j];
				else result[i][j] = Math.max(result[i-1][j-1], result[i-1][j]) + nums[i][j];
			}
		}
		
		int max = 0;
		for (int i = 0; i < result.length; i++) {
			if (result[N-1][i] > max) max = result[N-1][i];
		}
		System.out.println(max);
	}
}
