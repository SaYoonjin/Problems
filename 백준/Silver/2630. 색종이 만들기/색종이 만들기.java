import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int cw = 0;
	static int cb = 0;
	static int[][] nums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		nums = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		divide(0, 0, N);
		
		System.out.println(cw);
		System.out.println(cb);
		
	}
	public static void divide(int x, int y, int size) {
		if (check(x, y, size)) {
			if (nums[x][y] == 0) cw++;
			else cb++;
			return;
		}
		
		int ns = size / 2;
		divide(x, y, ns);
		divide(x, y + ns, ns);
		divide(x + ns, y, ns);
		divide(x + ns, y + ns, ns);
	}
	
	public static boolean check(int x, int y, int size) {
		int color = nums[x][y];
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (nums[i][j] != color) return false;
			}
		}
		return true;
	}
}
