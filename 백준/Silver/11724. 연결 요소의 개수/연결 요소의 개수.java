import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static List<Integer>[] nums;
    static boolean[] ch;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());	// 정점 6
        int M = Integer.parseInt(st.nextToken());	// 간선 5
        
        nums = new ArrayList[N+1];
        ch = new boolean[N+1];
        
        for (int i = 1; i <= N; i++) {
            nums[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            nums[a].add(b);
            nums[b].add(a); 
        }
        
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (!ch[i]) {   
                dfs(i);     
                cnt++;      
            }
        }
        
        System.out.println(cnt);
    }
    
    public static void dfs(int v) {
        ch[v] = true;
        
        for (int next : nums[v]) {
            if (!ch[next]) {
                dfs(next);
            }
        }
    }
}
