import java.util.*;

class Solution {
    
    static boolean[] isUsed;
    static String[] answer;
    static boolean isFinished;
    
    public String[] solution(String[][] tickets) {
        
        // 항상 ICN 출발
        // [a, b] -> a 에서 b로
        // 항공권 모두 사용
        // 가능한 경로 2개 이상 -> 알파벳 앞 순서 (정렬 필요)
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });
        
        answer = new String[tickets.length + 1];
        isUsed = new boolean[tickets.length];
        
        answer[0] = "ICN";
        dfs("ICN", tickets, 0);
        
        return answer;
        
    }
    
    static void dfs(String target, String[][] tickets, int cnt) {
        
        if (cnt == tickets.length) {
            isFinished = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(target) && !isUsed[i]) {
                
                isUsed[i] = true;
                answer[cnt + 1] = tickets[i][1];
                
                dfs(tickets[i][1], tickets, cnt + 1);
                
                if (isFinished) return;
                
                isUsed[i] = false;
                
            }
        }
        
    }

}