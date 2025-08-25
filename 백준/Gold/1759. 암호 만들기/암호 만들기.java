import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int L, C;
	public static char[] result;
	public static char[] chs;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		result = new char[L];
		chs = new char[C];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			chs[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(chs);

		crypto(0, 0);

		System.out.println(sb);
	}

	public static void crypto(int start, int cnt) {
		if (cnt == L) {
			if (check(result)) {
				for (int i = 0; i < L; i++) {
					sb.append(result[i]);
				}
				sb.append("\n");
			}
            return;
		}

		for (int i = start; i < C; i++) {
			result[cnt] = chs[i];
			crypto(i + 1, cnt + 1);
		}
	}
	
	public static boolean check(char[] arr) {
		int c1 = 0, c2 = 0;
		
		for (int i = 0; i < arr.length; i++) {
			char a = arr[i];
			if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') c1++;
			else c2++;
		}
		
		if (c1 < 1 || c2 < 2) return false;
		return true;
	}
}
