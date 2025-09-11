import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int cnt = 0, N;
	static List<Integer>[] nums;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		nums = new ArrayList[N+1];
		for (int i = 0; i < nums.length; i++) nums[i] = new ArrayList<>();
		
		int[] result = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nums[a].add(b);
			nums[b].add(a);
		}
		
		for (int i = 1; i < result.length; i++) {
			visited = new boolean[N+1];
			cnt = 0;
			bfs(i);
			result[i] = cnt;
		}
		
		int answer = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < result.length; i++) {
			if (min > result[i]) {
				min = result[i];
				answer = i;
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static void bfs(int a) { // a의 케빈 베이컨 수는?  
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(a);
		int[] each = new int[N+1];
		each[a] = 0;
		int idx = 0;
		
		while (!q.isEmpty()) {
			
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				
				for (int p : nums[now]) {
					if (!visited[p]) {
						each[p] = each[now] + 1;
						visited[p] = true;
						q.offer(p);
					}
				}
			}
			idx++;
		}
		for (int i = 1; i < each.length; i++) {
			cnt += each[i];
		}
	}
}
