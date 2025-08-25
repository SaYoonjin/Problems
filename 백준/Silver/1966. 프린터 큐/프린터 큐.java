import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 가장 앞 문서의 중요도 확인
		// 현재들 문서보다 중요도 높은 문서 있으면 -> 큐의 가장 뒤에 재배치
		// 그렇지 않으면 -> 바로 인쇄
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			Queue<Integer> nums = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				nums.add(Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 0;
			
			while (true) {
				int cur = nums.peek();	// 1
				
				int max = 0;
				
				for (int x : nums) {
					if (x > max) max = x;
				}
				
				if (cur < max) {
					nums.add(nums.poll());
					if (idx == 0) idx = nums.size()-1;
					else idx--;
				}
				
				else {
					nums.poll();
					cnt++;
					if (idx == 0) {
						System.out.println(cnt);
						break;
					}
					else {
						idx--;
					}
				}
			}
		}
	}
}
