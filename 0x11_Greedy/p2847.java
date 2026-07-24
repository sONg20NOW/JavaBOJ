package samsung01.boj;

import java.util.*;
import java.io.*;

public class p2847 {
	static int N;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int ans = 0;
		int last = nums[N-1];
		for (int i = N-2; i >= 0; i--) {
			if (nums[i] >= last) {
				int diff = nums[i] - last + 1;
				ans += diff;
				nums[i] -= diff;
			}
			last = nums[i];
		}
		
		System.out.println(ans);
		
		br.close();
	}

}
