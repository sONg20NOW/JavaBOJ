import java.util.*;
import java.io.*;

public class p1026 {
	static Integer[] A;
	static Integer[] B;
	static int N;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new Integer[N];
		B = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B, (a, b) -> b - a);
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += A[i] * B[i];
		}
		
		System.out.println(sum);
		
		br.close();
	}

}
