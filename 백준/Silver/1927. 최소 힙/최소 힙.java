import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 자연수 -> 배열에 넣기
		// 0 -> 배열에서 가장 작은 값 출력 후 제거
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> nums = new PriorityQueue<Integer>();
		
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (a == 0) {
				if (nums.isEmpty()) sb.append(0).append("\n");
				else sb.append(nums.poll()).append("\n");
			}
			else nums.add(a);
		}
		System.out.println(sb);
	}
}
