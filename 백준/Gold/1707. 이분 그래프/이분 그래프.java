import java.io.*;
import java.util.*;

public class Main {
	
	static List<Integer>[] graph;
    static int[] color;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			flag = true;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            color = new int[V + 1]; // 0: 미방문, 1/ -1: 색

            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            
            for (int i = 1; i <= V; i++) {
				if (color[i] == 0) {
					bfs(i);
				}
			}
            
            if (flag) System.out.println("YES");
            else System.out.println("NO");
            
		}
	}
	static boolean flag = true;
	
	public static void bfs(int a) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(a);
		color[a] = 1;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int ta : graph[now]) {
				if (color[ta] == 0) {
					color[ta] = -color[now];
					q.add(ta);
				}else if (color[ta] == color[now]) {
					flag = false;
				}
			}
		}
	}
}
