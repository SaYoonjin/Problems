import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		visited = new boolean[N+1];
		back(0);
		
		System.out.println(sb);
	}
	
	public static void back(int cnt) {
		
		if (cnt == N) {
			for (int x : nums) sb.append(x + " ");
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				nums[cnt] = i;
				back(cnt + 1);
				visited[i] = false;
			}
		}
	}
}
