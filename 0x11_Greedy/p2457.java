package samsung01.boj;

import java.util.*;
import java.io.*;

public class p2457 {
	static int N;
	static int[][] inputs;
	static int[][] dates;
	static int recent;

	public static void print() {
		for (int i = 0; i < N; i++) {
			System.out.printf("%d %d\n", dates[i][0], dates[i][1]);
		}
	}

	public static int nextDate(int date) {
		int month = date / 100;
		int day = date % 100;

		int max = 31;
		switch (month) {
		case 2:
			max = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			max = 30;
			break;
		}

		if (day + 1 > max) {
			day = 1;
			month += 1;
		} else {
			day += 1;
		}
		return month * 100 + day;
	}

	public static boolean findDate() {
//		System.out.printf("recent date is %d / next date is %d\n", recent, nextDate(recent));
		for (int i = 0; i < N; i++) {
//			위에서부터 recent를 포함하는 꽃 찾기
			if (dates[i][0] <= recent && recent < dates[i][1]) {
//				System.out.printf("%d %d\n", dates[i][0], dates[i][1]);
				recent = dates[i][1];
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		inputs = new int[N][4];
		dates = new int[N][2];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				inputs[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			dates[i][0] = inputs[i][0] * 100 + inputs[i][1];
			dates[i][1] = inputs[i][2] * 100 + inputs[i][3];
		}

		recent = 3 * 100 + 1;
		int target = 12 * 100 + 1;

//		정렬
		Arrays.sort(dates, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return b[1] - a[1];
		});

//		print();

		int ans = 0;
		while (recent < target) {
			if (findDate())
				ans++;
			else
				break;
		}

		if (recent < target)
			System.out.println(0);
		else {
			System.out.println(ans);
		}


		br.close();
	}

}
