package samsung01.boj;

import java.io.*;
import java.util.*;

public class p1744 {
	static int N;
	static ArrayList<Integer> neg = new ArrayList<>();
	static ArrayList<Integer> pos = new ArrayList<>();
	
	public static void printPos() {
		for (int i : pos) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void printNeg() {
		for (int i : neg) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n > 0) neg.add(n);
			else pos.add(n);
		}
		
		Collections.sort(pos, (a, b) -> a - b);
		Collections.sort(neg, (a, b) -> b - a);
		
		int sum = 0;
		int mul = 0;
		for (int i = 0; i < pos.size(); i++) {
			if (i % 2 == 0) {
				mul = pos.get(i);
			} else {
				mul *= pos.get(i);
				sum += mul;
				mul = 0;
			}
		}
		if (mul != 0)	sum += mul;
		
		mul = 0;
		for (int i = 0; i < neg.size(); i++) {
			if (i % 2 == 0) {
				mul = neg.get(i);
			} else {
				mul *= neg.get(i);
				sum += mul;
				mul = 0;
			}
		}
		if (mul != 0) 	sum += mul;
		
		System.out.println(sum);
		
		br.close();
	}

}
