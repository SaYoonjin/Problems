import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    // (1, 1) -> (N, N)

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 행렬 크기
        int[][] result = new int[N][N];   // 자리 배치
        int[] nums = new int[N*N];

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < N*N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            nums[i] = k;

            List<Integer> likes = new ArrayList<>();

            for (int j = 0; j < 4; j++) {
                likes.add(Integer.parseInt(st.nextToken()));
            }

            map.put(k, likes);

        }

        for (int now : nums) {

            int bestRow = -1, bestCol = -1;
            int bestEmpty = -1, bestLike = -1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    int emptyCnt = 0, likeCnt = 0;
                    if (result[i][j] != 0) continue;

                    for (int k = 0; k < 4; k++) {

                        int x = i + dr[k];
                        int y = j + dc[k];

                        if (x < 0 || x >= N || y < 0 || y >= N) continue;

                        if (result[x][y] == 0) {
                            emptyCnt++;
                        } else if (map.get(now).contains(result[x][y])) {
                            likeCnt++;
                        }
                    }

                    if (likeCnt > bestLike ||
                            (likeCnt == bestLike && emptyCnt > bestEmpty) ||
                            (likeCnt == bestLike && emptyCnt == bestEmpty && i < bestRow) ||
                            (likeCnt == bestLike && emptyCnt == bestEmpty && i == bestRow && j < bestCol)) {

                        bestRow = i;
                        bestCol = j;
                        bestLike = likeCnt;
                        bestEmpty = emptyCnt; // 여기서 best 판단
                    }
                }
            }

            result[bestRow][bestCol] = now;

        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                int student = result[i][j];
                int cnt = 0;

                for (int k = 0; k < 4; k++) {
                    int x = i + dr[k];
                    int y = j + dc[k];

                    if (x < 0 || x >= N || y < 0 || y >= N) continue;

                    if (map.get(student).contains(result[x][y])) {
                        cnt++;
                    }
                }

                if (cnt == 1) answer += 1;
                else if (cnt == 2) answer += 10;
                else if (cnt == 3) answer += 100;
                else if (cnt == 4) answer += 1000;
            }
        }

        System.out.println(answer);
    }

}
