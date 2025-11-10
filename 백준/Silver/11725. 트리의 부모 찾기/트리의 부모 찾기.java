import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		result = new int[N+1];
		
		nums = new ArrayList<>();
		for (int i = 0; i <= N; i++) nums.add(new ArrayList<>());
		
		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nums.get(a).add(b);
			nums.get(b).add(a);
		}
		
		bfs(1);
		
		for (int i = 2; i <= N; i++) sb.append(result[i]).append("\n");
		
		System.out.println(sb);
		
	}
	
	static boolean[] visited;
	static int[] result;
	static List<List<Integer>> nums;
	
	public static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int x : nums.get(now)) {
				if (!visited[x]) {
					visited[now] = true;
					result[x] = now;
					q.offer(x);
				}
			}
		}
	}
}
