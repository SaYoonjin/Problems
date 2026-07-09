import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 큐에 int[] {우선순위, 위치} 저장 
        // 하나 빼서 나머지랑 비교 -> 가장 크면 삭제 -> 삭제한 게 타겟이면 그 때 return 
        //                      -> 아니면 삭제 후 재삽입 
        
        int answer = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o2[0] - o1[0];
        });
        
        int idx = 0;
        for (int p : priorities) {
            q.offer(new int[] {p, idx});
            pq.offer(new int[] {p, idx++});
        }
        
        while (!q.isEmpty()) {

            int[] now = q.poll();
            int[] m = pq.peek();

            if (now[0] == m[0]) {
                pq.poll();
                answer++;

                if (now[1] == location) return answer;
            }
            else q.offer(now);

        }
        
        return answer;
        
    }
}