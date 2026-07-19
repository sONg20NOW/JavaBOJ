import java.util.*;
import java.io.*;

public class p1915 {

	static int n, m;
	static int[][] D;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		D = new int[n+1][m+1];
		
		for (int i = 0; i < n; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				D[i+1][j+1] = s[j] - '0';
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (D[i][j] == 1) {
					D[i][j] = Math.min(D[i-1][j-1], Math.min(D[i-1][j], D[i][j-1])) + 1;
					ans = Math.max(ans, D[i][j]);
				}
			}
		}
		
		System.out.println(ans * ans);
		
		br.close();
	}

}
