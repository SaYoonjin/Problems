import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] nums = new int[N+1];
		int[] result = new int[N + 1];
		
		for (int i = 0; i < N; i++) {
			 	nums[i] = Integer.parseInt(st.nextToken());
	        }
		 
		result[0] = nums[0];
        int max = result[0];

        for (int i = 1; i < N; i++) {
        	result[i] = Math.max(nums[i], result[i-1] + nums[i]); 
            max = Math.max(max, result[i]);
        }
		System.out.println(max);
	}
}
