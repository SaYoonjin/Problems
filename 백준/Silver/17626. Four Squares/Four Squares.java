import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] nums = new int[N + 1];

		nums[0] = 0;
		nums[1] = 1;
		int min = N;
		
		for (int i = 2; i < N + 1; i++) {
			min = N;

			for (int j = 1; j * j <= i; j++) {
				if ((1 + nums[i - j * j]) < min)
					min = 1 + nums[i - j * j];
			}
			nums[i] = min;
		}
		System.out.println(nums[N]);
	}
}
