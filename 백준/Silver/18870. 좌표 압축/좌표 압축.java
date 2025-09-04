import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());

		TreeSet<Integer> ts = new TreeSet<>();
		for (int i = 0; i < N; i++) ts.add(nums[i]);

		TreeMap<Integer, Integer> tm = new TreeMap<>();
		
		int idx = 0;
		for (int ta : ts) tm.put(ta, idx++);

		for (int i = 0; i < nums.length; i++) sb.append(tm.get(nums[i])).append(" ");
		
		System.out.println(sb);
	}
}
