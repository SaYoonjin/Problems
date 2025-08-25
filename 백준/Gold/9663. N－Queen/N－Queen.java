import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int N, result = 0;
	public static int[] queen; // queen[row] = col

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		queen = new int[N];

		backtracking(0);

		System.out.println(result);
	}

	public static void backtracking(int row) {

		// 다 채워졌으면 result 1 증가
		if (row == N) {
			result++;
			return;
		}

		// 가능한 자리면 해당 행의 열 값 저장 후 백트래킹
		for (int i = 0; i < N; i++) {
			if (check(row, i)) {
				queen[row] = i;
				backtracking(row + 1);
			}
		}
	}

	public static boolean check(int row, int col) {

		for (int i = 0; i < row; i++) {
			// 열 검사
			if (queen[i] == col)
				return false;
			// 대각선 검사
			if (Math.abs(row - i) == Math.abs(col - queen[i]))
				return false;
		}
		return true;
	}
}
