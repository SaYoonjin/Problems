class Solution {
    public String solution(String new_id) {
        
        // 1단계: 대문자를 소문자로 치환
        String answer = new_id.toLowerCase();
        
        // 2단계: 소문자, 숫자, -, _, . 제외한 문자 제거
        answer = answer.replaceAll("[^a-z0-9._-]", "");
        
        // 3단계: 마침표가 2번 이상 연속되면 하나로 치환
        answer = answer.replaceAll("\\.{2,}", ".");
        
        // 4단계: 처음이나 끝에 위치한 마침표 제거
        answer = answer.replaceAll("^\\.|\\.$", "");
        
        // 5단계: 빈 문자열이면 "a" 대입
        if (answer.length() == 0) {
            answer = "a";
        }
        
        // 6단계: 길이가 16 이상이면 첫 15개 문자만 남김
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("\\.$", "");
        }
        
        // 7단계: 길이가 2 이하이면 마지막 문자를 길이가 3이 될 때까지 반복
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }
        
        return answer;
    }
}