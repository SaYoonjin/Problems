import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();

		int[] degree = new int[N+1];
		int[] result = new int[N+1];
		int[] time = new int[N+1];
		List<Integer>[] nums = new ArrayList[N+1];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			
			if (a == 0) {
				dq.offer(i);
				result[i] = time[i];
			}
			
			for (int j = 0; j < a; j++) {
				int x = Integer.parseInt(st.nextToken());
				nums[x].add(i);
				degree[i]++;
			}
		}
		
		while (!dq.isEmpty()) {
			int ta = dq.poll(); //1
			
			for (int w : nums[ta]) {
				degree[w]--;
				if (degree[w] == 0) dq.offer(w);
				result[w] = Math.max(result[w], result[ta] + time[w]);
			}
		}
		
		int max = 0;
		for (int i = 0; i < result.length; i++) {
			if (max < result[i]) max = result[i];
		}
		System.out.println(max);
	}
}
