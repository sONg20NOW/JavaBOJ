import java.util.*;
import java.io.*;

public class p9461 {
	static int T;
	static int N;
	static long[] D = new long[101];
	
	static long FillDP(int k) {
		for (int i = 3; i <= k; i++) {
			if (D[i] > 0)	continue;
			D[i] = D[i-2] + D[i-3];
		}
		
		return D[k];
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		D[0] = 0; D[1] = 1; D[2] = 1;
		
		T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());
			
			if (D[N] > 0) {
				sb.append(D[N]).append("\n");
			} else {
				sb.append(FillDP(N)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
