import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static double[][] stars;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 별 개수 입력
        stars = new double[N][2];            // 별 좌표 저장
        visited = new boolean[N];            // MST에 포함 여부 체크

        // 별 좌표 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken()); // x
            stars[i][1] = Double.parseDouble(st.nextToken()); // y
        }

        double result = primWithPQ(); // PQ를 이용한 Prim MST 실행
        System.out.printf("%.2f\n", result); // MST 총 거리 출력
    }

    // PriorityQueue 기반 Prim 알고리즘
    static double primWithPQ() {
        double result = 0;

        // {거리, 노드 번호} 형태의 PQ (거리 기준 오름차순)
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> o[0]));
        pq.offer(new double[]{0, 0}); // 시작 노드: 0번 별, 거리 0

        while (!pq.isEmpty()) {
            double[] now = pq.poll();
            double dist = now[0];       // 현재 노드까지 거리
            int now_n = (int) now[1];       // 현재 노드 번호
            // 이미 MST에 포함된 노드면 건너뛰기
            if (visited[now_n]) continue;

            visited[now_n] = true;          // MST에 포함
            result += dist;             // 총 거리 누적

            // 현재 노드 기준으로 MST에 포함되지 않은 다른 노드까지 거리 계산 후 PQ에 추가
            for (int v = 0; v < N; v++) {
                if (!visited[v]) {
                    double nextDist = getDistance(stars[now_n], stars[v]); // 유클리드 거리 계산
                    pq.offer(new double[]{nextDist, v});
                }
            }
        }

        return result;
    }

    // 두 별 사이 거리 계산 (유클리드)
    static double getDistance(double[] a, double[] b) {
        return Math.sqrt(Math.pow(a[0]-b[0], 2) + Math.pow(a[1]-b[1], 2));
    }
}
