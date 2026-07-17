import java.util.*;
import java.io.*;

public class p9084 {
	
	static int T;
	static int N, M;
	static int[] coins;
	static int[] D;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			
			coins = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			D = new int[M+1];
			
			D[0] = 1;
			
			for (int price : coins) {
				for (int i = price; i <= M; i++) {
					D[i] += D[i-price];
				}
			}
			
			sb.append(D[M]).append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}

}
