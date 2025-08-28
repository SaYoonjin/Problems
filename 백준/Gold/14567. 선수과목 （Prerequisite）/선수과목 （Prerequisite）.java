import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 과목 수
		int M = Integer.parseInt(st.nextToken()); // 선수 조건의 수 
		int[] result = new int[N+1];
		
		Deque<Integer> dq = new ArrayDeque<>();
		int[] degree = new int[N+1];
		
		List<Integer>[] nums = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) nums[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nums[a].add(b);
			degree[b]++;
		}
		
		for (int i = 1; i < N+1; i++) {
			if (degree[i] == 0) {
				dq.offer(i);
				result[i] = 1;
			}
		}
		
		while (!dq.isEmpty()) {
			int b = dq.poll();
			for (int a : nums[b]) {
				result[a] = Math.max(result[a], result[b]+1);	
				degree[a]--;
				if (degree[a] == 0) dq.offer(a);
			}
		}
		
		for (int i = 1; i < result.length; i++) sb.append(result[i]).append(" ");
		System.out.println(sb);
	}
}