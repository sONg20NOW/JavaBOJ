import java.util.*;
import java.io.*;

public class p11047 {
	static int N, K;
	static int[] A;
	static int ans;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
				
		for (int i = N-1; i >= 0; i--) {
			ans += K / A[i];
			K %= A[i];
		}
		
		System.out.println(ans);
		
		br.close();
	}

}
