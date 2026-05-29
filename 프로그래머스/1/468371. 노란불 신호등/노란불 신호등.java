class Solution {
    public int solution(int[][] signals) {
        int limit = 1;

        for (int[] signal : signals) {
            int cycle = signal[0] + signal[1] + signal[2];
            limit = lcm(limit, cycle);
        }

        for (int time = 1; time <= limit; time++) {
            boolean allYellow = true;

            for (int[] signal : signals) {
                if (!isYellow(signal, time)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) {
                return time;
            }
        }

        return -1;
    }

    private boolean isYellow(int[] signal, int time) {
        int green = signal[0];
        int yellow = signal[1];
        int cycle = signal[0] + signal[1] + signal[2];

        int pos = (time - 1) % cycle + 1;

        return green < pos && pos <= green + yellow;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}