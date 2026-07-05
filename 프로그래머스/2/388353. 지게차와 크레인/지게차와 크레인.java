import java.util.*;

class Solution {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        int n = storage.length;
        int m = storage[0].length();

        char[][] map = new char[n + 2][m + 2];

        // 바깥 패딩은 빈 공간 '.'으로 채움
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], '.');
        }

        // 실제 창고 정보는 1칸 안쪽부터 저장
        int count = n * m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (String request : requests) {
            char target = request.charAt(0);

            // 크레인: 해당 알파벳 컨테이너 전부 제거
            if (request.length() == 2) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (map[i][j] == target) {
                            map[i][j] = '.';
                            count--;
                        }
                    }
                }
            } 
            // 지게차: 외부와 연결된 target 컨테이너만 제거
            else {
                boolean[][] visited = new boolean[n + 2][m + 2];
                Queue<int[]> queue = new LinkedList<>();
                List<int[]> removeList = new ArrayList<>();

                queue.offer(new int[]{0, 0});
                visited[0][0] = true;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2) {
                            continue;
                        }

                        if (visited[nx][ny]) {
                            continue;
                        }

                        visited[nx][ny] = true;

                        // 빈 공간이면 계속 이동 가능
                        if (map[nx][ny] == '.') {
                            queue.offer(new int[]{nx, ny});
                        } 
                        // 외부와 맞닿은 target 컨테이너면 제거 후보
                        else if (map[nx][ny] == target) {
                            removeList.add(new int[]{nx, ny});
                        }
                    }
                }

                // 같은 요청 안에서 연쇄적으로 제거되면 안 되므로 BFS 후 한 번에 제거
                for (int[] pos : removeList) {
                    int x = pos[0];
                    int y = pos[1];

                    if (map[x][y] == target) {
                        map[x][y] = '.';
                        count--;
                    }
                }
            }
        }

        return count;
    }
}