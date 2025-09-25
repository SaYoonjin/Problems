import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a, b) -> {
					if (a[1] == b[1]) return a[0] - b[0];
					return a[1] - b[1];
				});
		
		int N = Integer.parseInt(br.readLine());
		int end = 0, result = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.offer(new int[] {a, b});
		}
		
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			
			if (now[0] >= end) {
				result++;
				end = now[1];
			}
		}
		System.out.println(result);
	}
}
