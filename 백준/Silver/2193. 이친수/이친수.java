import java.io.*;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 0으로 시작하지 않음
		// 1이 두 번 연속 나타나지 않음
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[][] nums = new long[N+1][2];
		
		nums[1][0] = 0;
		nums[1][1] = 1;
		
		for (int i = 2; i <= N; i++) {
			nums[i][0] = nums[i-1][0] + nums[i-1][1];
			
			nums[i][1] = nums[i-1][0];
		}
		System.out.println(nums[N][0] + nums[N][1]);
	}
}
