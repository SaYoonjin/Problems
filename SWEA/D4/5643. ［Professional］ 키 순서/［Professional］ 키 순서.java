import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static int ta;
	public static List<Integer>[] nums1, nums2;
	public static boolean[] visited, visited2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			nums1 = new ArrayList[N+1];	//정방
			nums2 = new ArrayList[N+1];	//역방
			
			for (int i = 0; i < nums1.length; i++) {
				nums1[i] = new ArrayList<>();
				nums2[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				nums1[a].add(b);
				nums2[b].add(a);
			}
			
			int cnt = 0;
			for (int i = 1; i < N+1; i++) {
				visited = new boolean[N+1];
				visited2 = new boolean[N+1];
				boolean flag = true;
				ta = i;
				bfs();
				bfs2();
				
				for (int j = 1; j < visited.length; j++) {
					if (!visited[j] && !visited2[j]) {
						flag = false;
						break;
					}
				}
				if (flag) cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	public static void bfs() {
		Queue<Integer> nums = new ArrayDeque<Integer>();
		nums.add(ta);
		visited[ta] = true;
		
		while(!nums.isEmpty()) {
			int now = nums.poll();
			
			for (int a : nums1[now]) {
				if (!visited[a]) {
					visited[a] = true;
					nums.add(a);
				}
			}
			
		}
	}
	public static void bfs2() {
		Queue<Integer> nums = new ArrayDeque<Integer>();
		nums.add(ta);
		visited2[ta] = true;
		
		while(!nums.isEmpty()) {
			int now = nums.poll();
			for (int a : nums2[now]) {
				if (!visited2[a]) {
					visited2[a] = true;
					nums.add(a);
				}
			}
		}
	}
}
