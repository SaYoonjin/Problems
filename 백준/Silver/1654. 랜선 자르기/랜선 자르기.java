import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] nums = new int[K];
		long max = 0;
		
		for (int i = 0; i < K; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			if (nums[i] > max) max = nums[i];
		}
		
		long left = 1;
		long right = max;
		long result = 0;
		
		while (left <= right) {
			long mid = (left + right) / 2;
			int cnt = 0;
			for (int i = 0; i < nums.length; i++) {
				cnt += nums[i] / mid;
			}
			
			if (cnt >= N) {
				result = mid;
				left = mid + 1;
			}
			else if (cnt < N) right = mid - 1;
		}
		System.out.println(result);
	}
}
