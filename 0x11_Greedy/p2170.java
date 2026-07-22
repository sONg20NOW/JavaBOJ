package samsung01.boj;

import java.util.*;
import java.io.*;

public class p2170 {
	static int N;
	static ArrayList<long[]> list = new ArrayList<>();
	
	// 선분이 겹치면 그 선분을 업데이트하고, 겹치지 않으면 추가하는 함수
	static void addLine(long s, long e) {
		for (int i = 0; i < list.size(); i++) {
			long[] info = list.get(i);
			if ((info[0] >= s && e >= info[0]) || (e >= info[1] && s <= info[1])
					|| (info[0] <= s && e <= info[1]) || (s <= info[0] && info[1] <= e)) {
				list.remove(i);
				addLine(Math.min(s, info[0]), Math.max(e, info[1]));
				return;
			}
		}
		list.add(new long[] {s, e});
	}
	
	static int totalWidth() {
		int sum = 0;
		
		for (long[] info : list) {
			sum += (info[1] - info[0]);
		}
		
		return sum;
	}
	
	static void printLines() {
		for (long[] info: list) {
			System.out.printf("line is (%d, %d)\n", info[0], info[1]);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long s = Long.parseLong(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			
			addLine(s, e);
		}
		
		System.out.println(totalWidth());
		
//		printLines();
		br.close();
	}

}
