import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 10 20 10 30 20 50
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N];
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			result[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					result[i] = Math.max(result[i], result[j]+1);
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < result.length; i++) {
			if (ans < result[i]) ans = result[i];
		}
		System.out.println(ans);
	}
}
