import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static List<Integer>[] nums;
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		nums = new ArrayList[N+1];
		
		for (int i = 0; i < N+1; i++) {
			nums[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nums[a].add(b);
			nums[b].add(a);
		}
		
		for (int i = 1; i < N+1; i++) {
			visited = new boolean[N+1];
			dfs(i, 1);
			if (flag) break;
		}
		
		if (flag) System.out.println(1);
		else System.out.println(0);
	}
	
	static boolean[] visited;
	
	public static void dfs(int a, int b) {
		
		if (b == 5) {
			flag = true;
			return;
		}
		
		visited[a] = true;
		
		for (int x : nums[a]) {
			if (!visited[x]) {
				visited[x] = true;
				dfs(x, b+1);
			}
		}
		visited[a] = false;
	}
}
