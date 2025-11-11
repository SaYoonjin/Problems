import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] nums, result;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		visited = new boolean[N];
		result = new int[M];
		
		back(0);
		System.out.println(sb);
		
	}
	
	public static void back(int cnt) {
		
		if (cnt == M) {
			for (int i = 0; i < M; i++) sb.append(result[i]).append(" ");
				sb.append("\n");
				return;
		}	
		
		for (int i = 0; i < N; i++) {
			
			if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

			if (!visited[i]) {
				result[cnt] = nums[i];
				visited[i] = true;
				back(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
