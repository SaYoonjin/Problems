import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // n : 전체 학생 수 
        // lost : 도난당한 학생들 번호
        // reserve : 여벌의 체육복을 가져온 학생들 번호
        
        int[] students = new int[n];
        Arrays.fill(students, 1);
        
        for (int l : lost) students[l - 1]--;
        
        for (int r : reserve) students[r - 1]++;
        
        for (int i = 0; i < n; i++) {
            
            // 양 옆 하나만 
            if (students[i] == 2) {
                                
                if (i-1 >= 0 && students[i - 1] == 0) {
                    students[i - 1]++;
                    students[i]--;
                }
                
                else if (i+1 < n && students[i + 1] == 0) {
                    students[i + 1]++;
                    students[i]--;
                }
                
            }
            
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (students[i] >= 1) answer++;
        }
        
        return answer;
        
    }
}