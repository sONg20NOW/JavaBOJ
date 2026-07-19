import java.util.*;

public class p2193 {
	static int N;
	static int[][] D;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		N = sc.nextInt();
		
		D = new int[N + 1][2];
		
		D[1][0] = 0;
		D[1][1] = 1;
		
		for (int i = 2; i <= N; i++) {
			D[i][0] = D[i-1][0] + D[i-1][1];
			D[i][1] = D[i-1][0];
		}
		
		System.out.println(D[N][0] + D[N][1]);
		
		sc.close();
		
		return;
	}

}
