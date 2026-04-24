import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        int maxPick = nums.length / 2;
        int kindCount = set.size();
        
        return Math.min(maxPick, kindCount);
    }
}