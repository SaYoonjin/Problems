import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, a, b;
	static int result = 0;
	static List<Integer>[] nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		
		nums = new ArrayList[N+1];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			nums[c].add(d);
			nums[d].add(c);
		}
		
		System.out.println(bfs());
		
	}
	public static int bfs() {
		boolean[] check = new boolean[N+1];
		Queue<Integer> dq = new ArrayDeque<>();
		dq.add(a);
		check[a] = true;
		
		while (!dq.isEmpty()) {
			int size = dq.size();
			for (int i = 0; i < size; i++) {
				int ta = dq.poll();
				
				if (ta == b) return result;
				
				for (int tt : nums[ta]) {
					if (!check[tt]) {
						check[tt] = true;
						dq.add(tt);
					}
				}
			}
			result++;
		}
		return -1;
	}
}
