import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		back(0, 0, 0);
		System.out.println(cnt);
	}
	
	static int S, cnt = 0, N;
	
	public static void back(int idx, int result, int choose) {
		
		if (idx == N) {
		    if (result == S && choose != 0) cnt++;
		    return;
		}
		
		back(idx + 1, result, choose);
		back(idx + 1, result + nums[idx], choose + 1);
	}
}
