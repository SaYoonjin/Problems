import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(
				(a, b) -> {
					int absA = Math.abs(a);
					int absB = Math.abs(b);
					if (absA == absB) return a - b;
					return absA - absB;
				});
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n != 0) {
				pq.offer(n);
			}
			else if (n == 0 && pq.isEmpty()) sb.append(0).append("\n");
			else sb.append(pq.poll()).append("\n");
		}
		System.out.println(sb);
	}
}
