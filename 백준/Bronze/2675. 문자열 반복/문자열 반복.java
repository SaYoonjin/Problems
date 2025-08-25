import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int R = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			for (int i = 0; i < s.length(); i++) {
				char ss = s.charAt(i);
				for (int j = 0; j < R; j++) {
					sb.append(ss);
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
