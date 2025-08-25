import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> nums = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			
			if (a == 0) {
				if (nums.isEmpty()) System.out.println(0);
				else {
					System.out.println(nums.poll());
				}
			}
			else nums.add(a);
		}
    }
}
