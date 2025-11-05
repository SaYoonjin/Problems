import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int result = Integer.MAX_VALUE, N;
	static boolean[] WH;
	static int[] count;
	static List<Integer>[] nums;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		WH = new boolean[N];
		count = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < count.length; i++) {
			count[i] = Integer.parseInt(st.nextToken());
		}
		
		nums = new ArrayList[N];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for (int j = 0; j < a; j++) {
				nums[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int cnt = 0;
		
		f(WH, cnt);
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
		
	}
	
	public static void f(boolean[] WH, int cnt) {
		
		if (cnt == N) {
			if (isConnected(WH, true) && isConnected(WH, false)) {
				int red = 0, blue = 0;
				for (int i = 0; i < WH.length; i++) {
					if (!WH[i]) red += count[i];
					else blue += count[i];
				}
				int r = Math.abs(red - blue);
				if (r < result) result = r; 
			}
		}
		
		else {
			
			WH[cnt] = true;
			f(WH, cnt + 1);
			WH[cnt] = false;
			f(WH, cnt + 1);
			
		}
	}
	
	public static boolean isConnected(boolean[] WH, boolean flag) {
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		int cc = 0;
		
		for (int i = 0; i < visited.length; i++) {
			if (WH[i] == flag) {
				q.offer(i);
				visited[i] = true;
				break;
			}
		}
		if (q.isEmpty()) return false;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int x : nums[now]) {
				x--;
				if (!visited[x] && WH[x] == flag) {
					visited[x] = true;
					q.offer(x);
				}
			}
		}
		for (int i = 0; i < visited.length; i++) {
			if (WH[i] == flag && !visited[i]) return false;
		}
		return true;
	}
}
