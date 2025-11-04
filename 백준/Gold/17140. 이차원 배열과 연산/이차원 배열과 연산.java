import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int clen = 3, rlen = 3;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] nums = new int[100][100];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		while (result <= 100) {

			if (nums[r - 1][c - 1] == k) {
				System.out.println(result);
				return;
			}

			if (rlen >= clen)
				R(nums);
			else
				C(nums);

			result++;
		}

		System.out.println(-1);
	}

	// 각각의 수가 나온 횟수 오름차순
	// 같으면 수가 커지는 순

	// 행 or 열 크기가 100을 넘어가면 자름

	public static void R(int[][] nums) {

		int maxclen = 0;

		for (int i = 0; i < rlen; i++) {
			int[] count = new int[101];

			for (int j = 0; j < clen; j++) {
				if (nums[i][j] == 0)
					continue;
				count[nums[i][j]]++;
			}

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
				if (a[1] == b[1])
					return a[0] - b[0];
				return a[1] - b[1];
			});

			for (int j = 0; j < 101; j++) {
				if (count[j] > 0)
					pq.add(new int[] { j, count[j] });
			}

			int idx = 0;

			while (!pq.isEmpty()) {
				int[] now = pq.poll();
				if (idx >= 100)
					break;
				nums[i][idx++] = now[0];
				if (idx >= 100)
					break;
				nums[i][idx++] = now[1];
			}

			for (int j = idx; j < 100; j++) {
				nums[i][j] = 0;
			}

			maxclen = Math.max(maxclen, idx);
		}
		clen = maxclen;
	}

	public static void C(int[][] nums) {

		int maxrlen = 0;

		for (int i = 0; i < clen; i++) {
			int[] count = new int[101];

			for (int j = 0; j < rlen; j++) {
				if (nums[j][i] == 0)
					continue;
				count[nums[j][i]]++;
			}

			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
				if (a[1] == b[1])
					return a[0] - b[0];
				return a[1] - b[1];
			});

			for (int j = 0; j < 101; j++) {
				if (count[j] > 0)
					pq.add(new int[] { j, count[j] });
			}

			int idx = 0;

			while (!pq.isEmpty()) {
				int[] now = pq.poll();
				if (idx >= 100)
					break;
				nums[idx++][i] = now[0];
				if (idx >= 100)
					break;
				nums[idx++][i] = now[1];
			}

			for (int j = idx; j < 100; j++) {
				nums[j][i] = 0;
			}

			maxrlen = Math.max(maxrlen, idx);
		}
		rlen = maxrlen;
	}

}
