import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 입력 받기
	// 거리 배열 초기화 
	// 거리 입력 받기
	// 플로이드 워셜
	// 출력 
	
	static final int INF = 10000001;
	
	// 도시 개수
	// 버스 개수
	// 출발 / 도착 / 비용
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 도시 개수
		int M = Integer.parseInt(br.readLine()); // 버스 개수
		int[][] result = new int[N+1][N+1];
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				if (i == j) result[i][j] = 0;
				else result[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			result[a][b] = Math.min(result[a][b], c);
		}
		
		for (int k = 1; k < N+1; k++) {
			for (int i = 0; i < N+1; i++) {
				for (int j = 0; j < N+1; j++) {
					if (result[i][k] != INF && result[k][j] != INF &&
							result[i][j] > result[i][k] + result[k][j]) {
						result[i][j] = result[i][k] + result[k][j];
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (result[i][j] == INF) System.out.print(0 + " ");
				else System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
