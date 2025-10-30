import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static long[][] combi = new long[11][11];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i <= 10; i++) {
			combi[i][0] = combi[i][i] = 1;
			for (int j = 1; j < i; j++) {
				combi[i][j] = combi[i - 1][j - 1] + combi[i - 1][j];
			}
		}

		int len = 0, idx = N;

		if (N > 1022)
			sb.append(-1);
		else {
			for (int i = 1; i <= 10; i++) {
				if (idx < combi[10][i]) {
					len = i;
					break;
				}
				idx -= combi[10][i];
			}
		}

		int[] arr = new int[len];
		int last = 9;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j <= last; j++) {
				if (combi[j][len - i - 1] <= idx) {
					idx -= combi[j][len - i - 1];
				} else {
					arr[i] = j;
					last = j;
					break;
				}
			}
		}

		for (int i = 0; i < len; i++) {
		    sb.append(arr[i]);
		}

		System.out.println(sb);

	}

}
