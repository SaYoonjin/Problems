class Solution {
    public int[] solution(String s) {
        int transformCount = 0;
        int zeroCount = 0;

        while (!s.equals("1")) {
            int oneCount = 0;

            for (char c : s.toCharArray()) {
                if (c == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            s = Integer.toBinaryString(oneCount);
            transformCount++;
        }

        return new int[]{transformCount, zeroCount};
    }
}