import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] P;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		String[] mw = new String[N+1];
		for (int i = 1; i < mw.length; i++) mw[i] = st.nextToken();
		
		List<edge> elist = new ArrayList<edge>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edge e = new edge(a, b, c);
			elist.add(e);
		}
		
		P = new int[N+1];
		for (int i = 1; i < P.length; i++) P[i] = i;
		
		Collections.sort(elist);
		
		int result = 0;
		int cnt = 0;
		
		for (edge e : elist) {
			if (find(e.a) != find(e.b) && !(mw[e.a].equals(mw[e.b]))) {
				union(e.a, e.b);
				result += e.w;
				cnt++;
			}
		}
		if (cnt == N-1) System.out.println(result);
		else System.out.println(-1);
		
	}
	
	public static void union(int a, int b) {
		int root1 = find(a);
		int root2 = find(b);
		
		if (root1 == root2) return;
		else if (root1 > root2) P[root1] = root2;
		else P[root2] = root1;
	}
	
	public static int find(int a) {
		if (P[a] == a) return a;
		else return P[a] = find(P[a]); 
		}
	
	public static class edge implements Comparable<edge>{
		int a;
		int b;
		int w;
		
		public edge(int a, int b, int w) {
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
