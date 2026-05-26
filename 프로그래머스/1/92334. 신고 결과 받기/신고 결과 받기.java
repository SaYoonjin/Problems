import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];

        HashMap<String, Set<String>> reportMap = new HashMap<>();

        for (String s : report) {
            String[] arr = s.split(" ");
            String start = arr[0]; 
            String end = arr[1];   

            reportMap.computeIfAbsent(start, key -> new HashSet<>()).add(end);
        }

        HashMap<String, Integer> reportedCount = new HashMap<>();

        for (String reporter : reportMap.keySet()) {
            for (String reported : reportMap.get(reporter)) {
                reportedCount.put(reported, reportedCount.getOrDefault(reported, 0) + 1);
            }
        }

        HashMap<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
        }

        for (String reporter : reportMap.keySet()) {
            for (String reported : reportMap.get(reporter)) {
                if (reportedCount.get(reported) >= k) {
                    int idx = indexMap.get(reporter);
                    answer[idx]++;
                }
            }
        }

        return answer;
    }
}