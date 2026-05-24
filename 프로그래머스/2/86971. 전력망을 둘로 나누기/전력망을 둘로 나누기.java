import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        
        // 전선 하나 끊음 -> 전력망 네트워크 2개로 분할 
        // 송전탑의 개수 n, 전선 정보 wires
        // 전선들 중 하나 끊어서 송전탑 개수가 가능한 비슷하도록 나누기
        // 송전탑 개수 차이 return
        
        int answer = Integer.MAX_VALUE;
        
        nums = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) nums[i] = new ArrayList<>();
        
        for (int i = 0; i < wires.length; i++) {
            
            int a = wires[i][0];
            int b = wires[i][1];
            nums[a].add(b);
            nums[b].add(a);
            
        }
        
        for (int i = 0; i < wires.length; i++) {
            
            visited = new boolean[n + 1];
            r = 0;
                            
            int a = wires[i][0];
            int b = wires[i][1];
            
            nums[a].remove(Integer.valueOf(b));
            nums[b].remove(Integer.valueOf(a));
            
            count(a);
            int result1 = r;
            int result2 = n - result1;
            
            if (answer > Math.abs(result1 - result2)) answer = Math.abs(result1 - result2);
            
            nums[a].add(b);
            nums[b].add(a);
            
        }
        
        return answer;
        
    }
    
    static boolean[] visited;
    static List<Integer>[] nums;
    static int r = 0;
    
    public static void count(int a) {
        
        visited[a] = true;
        r++;
        
        for (int aa : nums[a]) {
            
            if (!visited[aa]) {
                count(aa);
            }
            
        }
        
    }
    
}