import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
         List<Integer> busTimes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            busTimes.add(540 + i * t); 
        }
        
        int idx = 0;
        int[] arriveTimes = new int[timetable.length];
        for (String time : timetable) {
            
            String[] part = time.split(":");
            int hour = Integer.parseInt(part[0]);
            int minute = Integer.parseInt(part[1]);
            
            arriveTimes[idx++] = hour * 60 + minute;
        }
        
        Arrays.sort(arriveTimes);
        
        int last = 0;
        int lastTime = 0;
        int lastBusCount = 0; 
        int answerTime = 0;
        
        for (int i = 0; i < busTimes.size(); i ++) {
            
            int bus = busTimes.get(i);
            int cnt = 0;
            
            while (last < arriveTimes.length &&
                    bus >= arriveTimes[last] &&
                    cnt < m) {
                lastTime = arriveTimes[last];
                last++;
                cnt++;
            }
            
            if (i == busTimes.size() - 1) {
                lastBusCount = cnt;
            }
            
        }
        
        int lastBusTime = busTimes.get(busTimes.size() - 1); 
        
        if (lastBusCount < m) {
            answerTime = lastBusTime;
        }
        else { 
            answerTime = lastTime - 1;
        }
        
        int hour = answerTime / 60;
        int minute = answerTime % 60;
        
        return String.format("%02d:%02d", hour, minute);
        
    }
}