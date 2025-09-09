import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] nums;
	static StringBuilder sb = new StringBuilder();
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String s = br.readLine();
			
			if (s.equals("0")) break;
			
			StringTokenizer st = new StringTokenizer(s, " ");
			N = Integer.parseInt(st.nextToken());
			nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			result = new int[6];
			
			backtracking(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
		   
	}
	
	public static void backtracking(int idx, int cnt) {
		if (cnt == 6) {
			for (int x : result) {
				sb.append(x + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i < N; i++) {
			result[cnt] = nums[i];
			backtracking(i + 1, cnt + 1);
		}
	}
}
