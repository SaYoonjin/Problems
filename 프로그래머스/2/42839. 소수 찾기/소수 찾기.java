import java.util.*;

class Solution {
    
    private Set<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        
        char[] ch = numbers.toCharArray();

        make(ch);
        
        int answer = 0;
        
        for (int n : numberSet) {
            if (isPrime(n)) answer++;
        }
        
        return answer;
        
    }
    
    public void make(char[] ch) {
        
        boolean[] visited = new boolean[ch.length];
        
        dfs(ch, visited, "");
        
    }
    
    private void dfs(char[] ch, boolean[] visited, String current) {
    
        if (!current.isEmpty()) {
            numberSet.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < ch.length; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            
            dfs(ch, visited, current + ch[i]);
            
            visited[i] = false;
        }
        
    }
    
    public boolean isPrime(int n) {
        
        if (n < 2) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
     
        return true;
    }
    
}