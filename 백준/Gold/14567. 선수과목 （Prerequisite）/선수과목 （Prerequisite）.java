import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		// 위상정렬 사용
		
		// 진입 차수가 0인 모든 노드를 큐에 넣음
		// 큐에서 원소 꺼냄
		
		// N : 과목 수
		// M : 선수 조건의 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		int[] indegree = new int[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			indegree[b]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		int[] semester = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
				semester[i] = 1;
			}
		}
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int next : graph.get(now)) {
				indegree[next]--;
				
				if (indegree[next] == 0) q.offer(next);
				semester[next] = Math.max(semester[next], semester[now]+1);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(semester[i]).append(" ");
		}
		System.out.println(sb);
		
	}
}
