import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static List<int[]> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			N = Integer.parseInt(br.readLine());
			int[][] nums = new int[N][N];
			list = new ArrayList<>();
			
			for (int i = 0; i < nums.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < nums.length; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			back(0, 0, new int[N/2]);
			
			int min = Integer.MAX_VALUE;
			
			while (!list.isEmpty()) {
				int[] now = list.remove(0);
				
				int r1 = 0, r2 = 0;
				boolean[] chosen = new boolean[N];
				for (int x : now) chosen[x] = true;

				List<Integer> n1 = new ArrayList<>();
				List<Integer> n2 = new ArrayList<>();

				for (int i = 0; i < N; i++) {
				    if (chosen[i]) n1.add(i);
				    else n2.add(i);
				}
				
				for (int i = 0; i < n1.size(); i++) {
					for (int j = 0; j < n1.size(); j++) {
						r1 += nums[n1.get(i)][n1.get(j)] + nums[n1.get(j)][n1.get(i)];
					}
				}
				for (int i = 0; i < n1.size(); i++) {
					for (int j = 0; j < n1.size(); j++) {
						r2 += nums[n2.get(i)][n2.get(j)] + nums[n2.get(j)][n2.get(i)];
					}
				}
				
				int rr = Math.abs(r1-r2);
				if (min > rr) min = rr;
			}
			min /= 2;
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	public static List<int[]> back(int a, int cnt, int[] pick){
		
		if (cnt == N / 2) {
			list.add(pick.clone());
			return list;
		}
		
		for (int i = a; i < N; i++) {
			pick[cnt] = i;
			back(i+1, cnt+1, pick);
		}
		return list;
	}
}
