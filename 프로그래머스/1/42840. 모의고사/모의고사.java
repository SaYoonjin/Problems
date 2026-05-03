import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int cnt1 = 0, cnt2 = 0, cnt3 = 0;
        
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};        
        
        for (int i = 0; i < answers.length; i++){
            
            int now = answers[i];
            
            if (p1[i % p1.length] == now) cnt1++;
            if (p2[i % p2.length] == now) cnt2++;
            if (p3[i % p3.length] == now) cnt3++;
            
        }
        
        int max = Math.max(cnt1, Math.max(cnt2, cnt3));
        
        List<Integer> list = new ArrayList<>();
        
        if (cnt1 == max) list.add(1);
        if (cnt2 == max) list.add(2);
        if (cnt3 == max) list.add(3);
        
        return list.stream().mapToInt(i -> i).toArray();
        
    }
}