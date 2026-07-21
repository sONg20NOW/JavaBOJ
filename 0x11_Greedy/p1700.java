package samsung01;

import java.util.*;
import java.io.*;

public class p1700 {

	static int N, K;
	static int[] nums;
	static Integer[] using;
	
	static boolean isInUsing(int n) {
		for (int i = 0; i < N; i++) {
			if (using[i] == Integer.valueOf(n))	return true;
		}
		return false;
	}
		
	// nums 배열에서 idx 이후에 num이 어딨는지 반환하는 함수
	// nums 배열에서 idx 이후에 num이 없으면 K 반환
	static int afterIdxAt(int num, int idx) {
		for (int i = idx + 1; i < K; i++) {
			if (nums[i] == num) {
				return i;
			}
		}
		return K;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		using = new Integer[N];
		nums = new int[K];
		
		for (int i = 0; i < K; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int using_n = 0;
		for (int i = 0; i < K; i++) {
			// 이미 멀티탭에 꽂혀있으면
			if (isInUsing(nums[i])) continue;
			// using 배열이 꽉 차지 않았으면 using 배열에 추가.
			if (using_n < N) {
				using[using_n++] = nums[i];
				continue;
			}


			final int cur_idx = i;
			// using 배열 정렬
			Arrays.sort(using, (a, b) -> {
				int a_idx = afterIdxAt((int) a, cur_idx);
				int b_idx = afterIdxAt((int) b, cur_idx);
				return a_idx - b_idx;
			});
			
			ans++;
			using[N-1] = nums[i];
		}
		
		System.out.println(ans);
	}

}
