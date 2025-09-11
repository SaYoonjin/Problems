import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] nums;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 0 -> 1
		// 1 -> 2
		// 2 -> 0
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N][N];
		
		for (int i = 0; i < nums.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < nums.length; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int k = 0; k < nums.length; k++) {
			for (int i = 0; i < nums.length; i++) {
				for (int j = 0; j < nums.length; j++) {
					if (nums[i][j] == 0 && nums[i][k] == 1 && nums[k][j] == 1) {
						nums[i][j] = 1;
					}
				}
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				System.out.print(nums[i][j] + " ");
			}
			System.out.println();
		}
	}
}
