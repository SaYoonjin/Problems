import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] nums;
    static boolean[] visited;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        result = new int[N+1];
        nums = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) nums[i] = new ArrayList<>();

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nums[a].add(b);
            nums[b].add(a);
        }
        bfs(1);

        System.out.println(sb);
    }

    static Queue<Integer> q = new ArrayDeque<>();

    public static void bfs(int start){
        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()){
            int now = q.poll();

            for (int x : nums[now]){
                if (!visited[x]){
                    visited[x] = true;
                    q.offer(x);
                    result[x] = now;
                }
            }
        }

        for (int i = 2; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }

    }

}
