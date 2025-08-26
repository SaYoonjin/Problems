import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		
		int c = 0;
		int left = 0, right = nums[nums.length-1];
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			long sum = 0;
			
			
			for (int i = 0; i < nums.length; i++) {
				int m = nums[i] - mid;
				if (m > 0) sum += m;
			}
			
			if (sum < M) right = mid - 1;
			else {
				c = mid;
				left = mid + 1;
			}
		}
		System.out.println(c);
	}
}
