import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		int left = 0, right = 0, result = 0;
		
		HashMap<Integer, Integer> count = new HashMap<>();
		for (right = 0; right < N; right++) {
			count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
			
			while (count.size() > 2) {
				count.put(nums[left], count.getOrDefault(nums[left], 0) - 1);
				if (count.get(nums[left]) == 0) count.remove(nums[left]);
				left++;
			}
			result = Math.max(result, right - left + 1);
		}
		System.out.println(result);
	}
}
