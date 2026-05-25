import java.util.*;

class Solution {
    public int solution(String s) {
        
        // 자르는 단위수를 늘리면서 
        // 1 ~ N/2
        
        // 지금 거 저장 
        // 다음 거 비교하면서 cnt++ 하다가 달라지면 cnt 저장하고 0 초기화 & 지금 거 업데이트
        // 전체 글자 수 다 센 뒤에 answer 랑 비교
        
        int n = s.length();
        int idx = 0;
        int answer = n;
        
        for (int i = 1; i <= n / 2; i++) {   // 자르는 단위 수
            
            String now = s.substring(idx, idx + i);
            idx += i;
            int result = 0;
            int cnt = 1;
                        
            while (idx < n) {
                
                int end = Math.min(idx + i, n);
                String next = s.substring(idx, end);        
                
                if (now.equals(next)) {
                    cnt++;
                    idx += i;
                }
                else {
                    
                    if (cnt > 1) result += (String.valueOf(cnt).length() + i);
                    else result += now.length();
                    
                    now = next;
                    idx += i;
                    cnt = 1;
                    
                }
                
            }
            
            if (cnt > 1) result += String.valueOf(cnt).length();
            result += now.length();
            
            if (result < answer) answer = result;
            idx = 0;
            
        }
        
        return answer;
        
    }
}