import java.util.*;

class Solution {
    
    static boolean[] visited;
    static char[] order;
    static long answer;
    
    public long solution(String expression) {
        
        // 연산자의 우선순위 재정의 -> 가장 큰 숫자 제출
        // 음수는 절댓값 처리 
        
        answer = 0;
        
        Set<Character> set = new HashSet<>();
        
        for (int i = 0; i < expression.length(); i++) {
            
            char c = expression.charAt(i);
            if (c < '0' || c > '9') set.add(c);
            
        }
        
        visited = new boolean[set.size()];
        order = new char[set.size()];
        
        char[] cal = new char[set.size()];
        int idx = 0;
        for (char c : set) cal[idx++] = c;

        make(cal, 0, expression);
        
        return answer;
        
    }
    
    public static void make(char[] cal, int cnt, String expression) {
        
        if (cnt == cal.length) {
            
            long result = calculate(expression, order);
            
            answer = Math.max(Math.abs(result), answer);
            
            return;
            
        }
        
        for (int i = 0; i < cal.length; i++) {
            
            if (!visited[i]) {
                
                visited[i] = true;
                order[cnt] = cal[i];
                
                make(cal, cnt + 1, expression);
                
                visited[i] = false;
                
            }
            
        }
        
    }
    
    public static long calculate(String expression, char[] order) {
            
        List<Long> nums = new ArrayList<>();
        List<Character> operation = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {

            char c = expression.charAt(i);

            if (c >= '0' && c <= '9') sb.append(c);

            else {
                nums.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operation.add(c);
            }
        }
        nums.add(Long.parseLong(sb.toString()));
        
        for (int i = 0; i < order.length; i++) {

            char op = order[i]; 

            for (int j = 0; j < operation.size(); ) {

                if (operation.get(j) == op) {

                    long a = nums.get(j);
                    long b = nums.get(j + 1);

                    long result = 0;

                    if (op == '+') {
                        result = a + b;
                    } else if (op == '-') {
                        result = a - b;
                    } else if (op == '*') {
                        result = a * b;
                    }

                    nums.set(j, result);

                    nums.remove(j + 1);

                    operation.remove(j);

                } else {
                    j++;
                }
            }
        }

    return nums.get(0);
            
    }
    
}