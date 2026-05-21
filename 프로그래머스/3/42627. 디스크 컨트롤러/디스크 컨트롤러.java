import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        // 작업의 번호, 작업의 요청 시각, 작업의 소요 시간
        // 소요시간이 짧은 것, 요청 시각이 빠른 것, 번호가 작은 것 순
        
        int n = jobs.length;
        int[][] arr = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            arr[i][0] = jobs[i][0]; 
            arr[i][1] = jobs[i][1]; 
            arr[i][2] = i;          
        }
        
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[2], b[2]);
            return Integer.compare(a[0], b[0]);
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
            if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[2], o2[2]);
        });
        
        int time = 0;
        int total = 0;
        int idx = 0;
        int count = 0;
        
        while (count < n) {
            
            while (idx < n && arr[idx][0] <= time) {
                pq.offer(arr[idx]); 
                idx++;     
                
            }
            
            if (!pq.isEmpty()) {
                
                int[] now = pq.poll();
                time += now[1];
                total += time - now[0];
                count++;
                
            }
            
            
            else {
                time = arr[idx][0];
            }
            
        }
        
        return total / n;
                
    }
}