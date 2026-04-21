import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] nums;
    static int N, M;
    static List<Node> nodes;
    static int[] parent;

    static class Node implements Comparable<Node> {

        int to, from, cost;

        public Node (int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 라벨링 과정 (2 ~ idx  -1)
        int idx = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (nums[i][j] == 1) {

                    bfs(i, j, idx);
                    idx++;

                }

            }
        }

        nodes = new ArrayList<>();

        // 섬 간의 거리 측정
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (nums[i][j] != 0) {
                    dist(i , j);
                }

            }
        }

        //크루스칼 수행
        parent = new int[idx];
        for (int i = 2; i < idx; i++) {
            parent[i] = i;
        }

        Collections.sort(nodes);

        int total = 0;
        int count = 0;

        for (Node node : nodes) {

            if (find(node.from) != find(node.to)) {

                union(node.from, node.to);
                total += node.cost;
                count++;

            }

        }


        // 섬이 0개인 경우 고려해야 함
        int islandCount = idx - 2;

        if (islandCount <= 1) System.out.println(0);
        if (count == islandCount - 1) System.out.println(total);
        else System.out.println(-1);


    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    // 섬 라벨링
    public static void bfs(int x, int y, int idx) {

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        nums[x][y] = idx;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {

                int xx = now[0] + dr[i];
                int yy = now[1] + dc[i];

                if (xx < 0 || yy < 0 || xx >= N || yy >= M) continue;

                if (nums[xx][yy] == 1) {
                    nums[xx][yy] = idx;
                    q.offer(new int[] {xx, yy});
                }

            }

        }

    }

    // 섬 간 거리 측정 메서드
    public static void dist(int x, int y) {
        int from = nums[x][y];

        for (int d = 0; d < 4; d++) {
            int xx = x;
            int yy = y;
            int length = 0;

            while (true) {
                xx += dr[d];
                yy += dc[d];

                if (xx < 0 || yy < 0 || xx >= N || yy >= M) break;

                if (nums[xx][yy] == from) break;

                if (nums[xx][yy] == 0) {
                    length++;
                    continue;
                }

                if (nums[xx][yy] != 0) {
                    if (length >= 2) {
                        int to = nums[xx][yy];
                        nodes.add(new Node(from, to, length));
                    }
                    break;
                }
            }
        }
    }

    // 부모 노드 찾기
    public static int find(int x) {

        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);

    }

    // 병합 메서드
    public static void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        if (rootA < rootB) parent[rootB] = rootA;
        else parent[rootA] = rootB;

    }

}
