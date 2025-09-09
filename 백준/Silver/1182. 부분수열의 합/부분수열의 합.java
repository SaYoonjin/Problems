import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, S, result = 0, sum = 0;
	static int[] nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 0;
		sum = 0;
		backtracking(idx, sum);
		if (S == 0) result --;
		
		System.out.println(result);
	}
	
	public static void backtracking(int idx, int sum) {
		
		if (idx == N) {
			if (sum == S) result++;
			return;
		}
		backtracking(idx + 1, sum + nums[idx]);
		backtracking(idx + 1, sum);
	}

}
