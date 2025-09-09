import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<Integer> nums = new ArrayList<>();
		boolean[] visited = new boolean[N+1];
		backtracking(0, nums, visited);
		
		System.out.println(sb);
	}
	
	public static void backtracking(int cnt, List<Integer> nums, boolean[] visited) {
		
		if (cnt == M) {
			for (int x : nums) {
				sb.append(x + " ");
			}
			sb.append("\n");
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				nums.add(i);
				visited[i] = true;
				backtracking(cnt + 1, nums, visited);
				nums.remove(nums.size()-1);
				visited[i] = false;
			}
		}
	}
}
