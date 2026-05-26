import java.util.*;

class Solution {
    
    static int result = 0;
    
    public int[] solution(int[] fees, String[] records) {
        
        // 입차 이후 내역 없으면 23:59 출차 간주
        // 단위 시간으로 나누어 떨어지지 않으면 올림
        // 차량 번호가 작은 자동차부터 배열로 담아서 return
        
        int N = records.length;
        String[][] arr = new String[records.length][3];
        
        for (int i = 0; i < N; i++) {
            
            arr[i] = records[i].split(" ");
            
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            
            String now = arr[i][0];
            String[] arr2 = now.split(":");
            int time = (Integer.parseInt(arr2[0]) * 60) + Integer.parseInt(arr2[1]);
            
            int num = Integer.parseInt(arr[i][1]);
            
            map.computeIfAbsent(num, k -> new ArrayList<>()).add(time);
            
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        int idx = 0;
        
        for (int car : list) {  // 차 번호 하나 뽑고
            
            List<Integer> times = map.get(car);
            result = 0;
            
            calculation(times, fees);
            
            answer[idx++] = result;
            
        }
        
        return answer;
        
    }
    
    public static void calculation(List<Integer> times, int[] fees) {
        
        int s = times.size();
        
        if (s % 2 == 1) times.add(60 * 23 + 59);
        
        int t = 0;
        
        for (int i = 0; i < times.size(); i += 2) t += times.get(i + 1) - times.get(i);
        
        if (t <= fees[0]) result += fees[1];
        else {
            
            result += fees[1];
            t -= fees[0];
            
            if (t % fees[2] == 0) result += (t / fees[2]) * fees[3];
            else result += (t / fees[2] + 1) * fees[3];
            
        }
        
    }
}