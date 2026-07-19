
import java.util.*;
import java.io.*;

public class p9251 {

	static char[] a;
	static char[] b;
	static int[][] D;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		
		int N = a.length;
		int M = b.length;
		D = new int[N + 1][M + 1];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (a[i] == b[j]) {
					D[i+1][j+1] = D[i][j] + 1;
				} else {
					D[i+1][j+1] = Math.max(D[i][j+1], D[i+1][j]);
				}
			}
		}
		
		System.out.println(D[N][M]);
		
		br.close();
	}

}
