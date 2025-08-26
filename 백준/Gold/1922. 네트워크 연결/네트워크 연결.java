import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static int[] P;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		List<edge> elist = new ArrayList<edge>();
		
		P = new int[V+1];
		for (int i = 1; i <= V; i++) P[i] = i;
		
		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edge m = new edge(a, b, c);
			elist.add(m);
		}
		Collections.sort(elist);
		
		int result = 0;
		
		for (edge e : elist) {
			if (find(e.a) != find(e.b)) {
				union(e.a, e.b);
				result += e.w;
			}
		}
		System.out.println(result);
	}

	public static void union(int a, int b) {
		int p1 = find(a);
		int p2 = find(b);
		
		if (p1 == p2) return;
		
		else if (p1 > p2) P[p1] = p2;
		else P[p2] = p1;
	}
	
	public static int find(int x) {
		if (P[x] == x) return x;
		else return P[x] = find(P[x]);
	}
	
	public static class edge implements Comparable<edge>{

		int a;
		int b;
		int w;

		public edge(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(edge o) {
			return this.w - o.w;
		}
	}
}