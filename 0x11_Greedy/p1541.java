package samsung01;

import java.util.*;
import java.io.*;

public class p1541 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		Stack<Integer> ST = new Stack<>();
		char[] s = br.readLine().toCharArray();
		
		int ans = 0;
		boolean minus = false;
		
		int num = 0;

		for (int c : s) {
			if (c == '-') {
//				System.out.printf("%d is added!\n", num);
				ST.add(num);
				num = 0;
				int sum = 0;
				while(!ST.isEmpty()) {
					int cur = ST.pop();
					sum += cur;
				}
				if (minus) {
					ans -= sum;
				} else {
					ans += sum;
				}
				minus = true;
			} else if (c == '+') {
//				System.out.printf("%d is added!\n", num);
				ST.add(num);
				num = 0;
			} else {
				num *= 10;
				num += (c - '0');
			}
		}
		ST.add(num);
		int sum = 0;
		// 마지막에 ST 비우기
		while(!ST.isEmpty()) {
			int cur = ST.pop();
			sum += cur;
		}
		if (minus) {
			ans -= sum;
		} else {
			ans += sum;
		}
		
		System.out.println(ans);
		
		br.close();
	}

}
