import java.util.*;

class Solution {
    
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<>();
        
        int idx = 0;
        
        while (idx < s.length()) {
            
            Character c = s.charAt(idx);
            
            if (c == '(') {
                st.push(c);
                idx++;
            }
            else {
                if (!st.isEmpty()) {
                    st.pop();
                    idx++;
                }
                else {
                    answer = false;
                    return answer;
                }
            }
            
        }
        
        if (!st.isEmpty()) answer = false;

        return answer;
    }
}