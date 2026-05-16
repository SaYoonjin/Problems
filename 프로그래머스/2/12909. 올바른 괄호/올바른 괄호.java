import java.util.*;

class Solution {
    boolean solution(String s) {
        
        char[] c = new char[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            
            c[i] = s.charAt(i);
            
        }
        
        Queue<Character> q = new ArrayDeque<>();
        
        for (char a : c) {
            
            if (q.isEmpty() || a == '(') q.offer(a);
            else if (a == ')') {
                if (!q.isEmpty()) q.poll();
                else return false;
            }
            
        }
        
        if (!q.isEmpty()) return false;
        else return true;
        
    }
}