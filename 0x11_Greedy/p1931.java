package Greedy;

import java.util.*;
import java.io.*;

public class p1931 {
	static int N;
	static int[][] Meeting;
	
	static void printMeeting() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			sb.append(Meeting[i][0]).append(" ").append(Meeting[i][1]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Meeting = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Meeting[i][0] = Integer.parseInt(st.nextToken());
			Meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬 (시작시간 오름차순 정렬 + 종료시간 내림차순 정렬)
		Arrays.sort(Meeting, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});
		
		int t = 0;
		int cnt = 0;
		// 1. 현재 시간 이후에 시작하는 회의 중 가장 빨리 끝나는 회의 찾기
		// 2. 그 회의의 종료 시간으로 t 설정 & cnt++
		// 3. 아무 회의도 선택되지 않을 때까지 반복

		for (int i = 0; i < N; i++) {
			if (Meeting[i][0] < t) continue;
			t = Meeting[i][1];
			cnt++;
		}
		
		System.out.println(cnt);
		br.close();
	}

}
