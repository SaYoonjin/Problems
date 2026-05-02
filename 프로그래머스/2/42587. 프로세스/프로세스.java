import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            boolean hasHigher = false;

            for (int[] item : q) {
                if (item[0] > cur[0]) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                q.offer(cur); 
            } else {
                answer++;

                if (cur[1] == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}