import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        Set<String> spoilerWords = new HashSet<>();
        Set<String> normalWords = new HashSet<>();

        int n = message.length();
        int rangeIdx = 0;
        int i = 0;

        while (i < n) {
            if (message.charAt(i) == ' ') {
                i++;
                continue;
            }

            int start = i;

            while (i < n && message.charAt(i) != ' ') {
                i++;
            }

            int end = i - 1;

            // 현재 단어보다 완전히 왼쪽에 있는 스포 구간은 넘김
            while (rangeIdx < spoiler_ranges.length &&
                   spoiler_ranges[rangeIdx][1] < start) {
                rangeIdx++;
            }

            boolean isSpoiler = false;

            // 현재 스포 구간이 단어와 겹치면 스포 단어
            if (rangeIdx < spoiler_ranges.length &&
                spoiler_ranges[rangeIdx][0] <= end &&
                spoiler_ranges[rangeIdx][1] >= start) {
                isSpoiler = true;
            }

            String word = message.substring(start, end + 1);

            if (isSpoiler) {
                spoilerWords.add(word);
            } else {
                normalWords.add(word);
            }
        }

        int answer = 0;

        for (String word : spoilerWords) {
            if (!normalWords.contains(word)) {
                answer++;
            }
        }

        return answer;
    }
}