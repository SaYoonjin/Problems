import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        System.out.println(fac(1, N));
    }

    public static BigInteger fac(int a, int n) {
        BigInteger num = BigInteger.valueOf(a);

        if (a < n){
            int b = (a + n) / 2;
            num = fac(a, b).multiply(fac(b+1, n));
        }
        return num;
    }
}
