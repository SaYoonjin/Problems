import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 남은 작업량 구하기 [7, 70, 45]
        // 필요한 날짜 구하기 [3, 3, 9]
        
        int N = progresses.length;
        int[] left = new int[N];
        
        for (int i = 0; i < N; i++) {
            
            int nn = 100 - progresses[i];
            if (nn % speeds[i] == 0) left[i] = nn / speeds[i];
            else left[i] = nn / speeds[i] + 1;
            
        }
        
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        
        // [3, 3, 9]
        while (idx < N) {
            
            int cnt = 1;
            int now = left[idx++];  // 3
            
            while (idx < N && now >= left[idx]) {
                
                cnt++;  // 2
                idx++;  // 2
                
            }
            
            result.add(cnt);
            
        }
        
        idx = 0;
        
        int[] answer = new int[result.size()];
        for (int a : result) {
            answer[idx++] = a;
        }
        
        return answer;
        
    }
}