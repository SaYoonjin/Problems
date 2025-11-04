import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public interface Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] nums = new int[N+1][2];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums[i][0] = Integer.parseInt(st.nextToken());
			nums[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[N+2];
		
		int idx = N;
		
		while (idx >= 1) {
			if (nums[idx][0] + idx - 1 > N) result[idx] = result[idx+1];
			else {
				result[idx] = Math.max(result[idx+1], nums[idx][1] + result[nums[idx][0] + idx]);
			}
			idx--;
		}
		
		System.out.println(result[1]);
	}
}