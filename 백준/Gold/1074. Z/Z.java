import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int result = 0, r, c;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int nn = (int)Math.pow(2, N);
		
		cal(nn, 0, 0);
		
		System.out.println(result);
	}
	
	public static void cal(int N, int rr, int cc) {
		if (N == 1) return;
		
		N /= 2;
		int a = N*N;
		
		if (r < rr + N && c < cc + N) cal(N, rr, cc);
		if (r < rr + N && c >= cc + N) {
			result += a;
			cal(N, rr, cc+N);
		}
		if (r >= rr + N && c < cc + N) {
			result += a * 2;
			cal(N, rr+N, cc);
		}
		if (r >= rr + N && c >= cc + N) {
			result += a * 3;
			cal(N, rr+N, cc+N);
		}
	}

}
