package samsung01.swea;

import java.util.*;
import java.io.*;

public class p5642 {
	static int N;
	static int[] nums;
	static int[] D;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T=Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			N = Integer.parseInt(br.readLine());
			nums = new int[N];
			D = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			D[0] = nums[0];
			int max = D[0];
			for (int i = 1; i < N; i++) {
				D[i] = Math.max(nums[i], nums[i] + D[i-1]);
				max = Math.max(max, D[i]);
			}
			
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb.toString());
		
		br.close();
	}

}
