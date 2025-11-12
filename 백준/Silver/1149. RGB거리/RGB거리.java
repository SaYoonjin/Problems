
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] nums = new int[N][3];
		int[][] result = new int[N][3];
		for (int i = 0; i < nums.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
			nums[i][2] = Integer.parseInt(st.nextToken());
		}
		
		result[0][0] = nums[0][0];
		result[0][1] = nums[0][1];
		result[0][2] = nums[0][2];
		
		for (int i = 1; i < result.length; i++) {
			result[i][0] = nums[i][0] + Math.min(result[i-1][1], result[i-1][2]);
			result[i][1] = nums[i][1] + Math.min(result[i-1][0], result[i-1][2]);
			result[i][2] = nums[i][2] + Math.min(result[i-1][0], result[i-1][1]);
		}
		
		int ans = Math.min(result[N-1][0], Math.min(result[N-1][1], result[N-1][2]));
		
		System.out.println(ans);
	}
}
