package samsung01.boj;

import java.io.*;
import java.util.*;

public class p7570 {

	static int N;
	static int[] D;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		D = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		
		for (int i = 0; i < N ;i++) {
			int num = Integer.parseInt(st.nextToken());
			D[num] = D[num-1] + 1;
			max = Math.max(max,  D[num]);
		}
		
		System.out.println(N - max);
		
		br.close();
	}

}
