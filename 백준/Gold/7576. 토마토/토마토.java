import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M, cnt, level = 0;
    static int[][] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        nums = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                if (nums[i][j] == 0) cnt++;
                else if (nums[i][j] == 1) q.offer(new int[] {i, j});
            }
        }
        if (cnt == 0) {
            System.out.println(cnt);
            return;
        }


        int days = bfs(q);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (nums[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);
    }



    public static int bfs(Queue<int[]> q){

        int days = -1;

        while (!q.isEmpty()){
            int size = q.size();
            days ++;
            for (int i = 0; i < size; i++) {
                int[] now = q.poll();

                for (int j = 0; j < 4; j++) {
                    int x = now[0] + dr[j];
                    int y = now[1] + dc[j];
                    if (x < 0 || x >= N || y < 0 || y >= M) continue;

                    if (nums[x][y] == 0) {
                        nums[x][y] = 1;
                        q.offer(new int[] {x, y});
                    }
                }
            }
        }
        return days;
    }
}
