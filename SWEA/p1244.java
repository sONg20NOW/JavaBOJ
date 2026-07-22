package samsung01.swea;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;

class p1244 {
	static int[] nums;
	static int cnt;
	
	static int[] arr;
	static int ans;
	
	static Map<Integer, Boolean>[] map = new HashMap[2];
	
	static int numsToInt() {
		int n = 0;
		for (int i = 0; i < nums.length; i++) {
			n *= 10;
			n += nums[i];
		}
		
		return n;
	}
	
	static void func(int k) {
		int res = numsToInt();

		if (k == cnt) {
//			for (int n : nums) {
//				System.out.printf("%d ", n);
//			}
//			System.out.println();
			ans = Math.max(ans, res);
			return;
		}
		
		if (map[res % 2].containsKey(res))	return;
		map[res%2].put(res, true);
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {	
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				
				func(k + 1);
				
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			ans = 0;
			
			map[0] = new HashMap<>();
			map[1] = new HashMap<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
				
			char[] num = st.nextToken().toCharArray();
			cnt = Integer.parseInt(st.nextToken());
			nums = new int[num.length];
			arr = new int[num.length];
			
			for (int i = 0; i < num.length; i++) {
				nums[i] = num[i] - '0';
			}
			
			Character[] chars = new Character[num.length];
			for (int i = 0; i < num.length; i++) {
				chars[i] = num[i];
			}
			
			Arrays.sort(chars, (a, b) -> b - a);
			
			func(0);
			
			System.out.printf("#%d %d\n", test_case, ans);
			
		}
		
		br.close();
	}
}