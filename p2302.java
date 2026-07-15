import java.util.*;

public class p2302 {
	static int N, M;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static int[][] D;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int max = 0;
		
		int l = 0;
		int r;
		for (int i = 0; i < M; i++) {
			r = sc.nextInt();
			list.add(r - l - 1);
			max = Math.max(max, r - l - 1);
			l = r;
		}
		r = N + 1;
		list.add(r - l - 1);
		max = Math.max(max, r - l - 1);
		
		D = new int[max + 2][2];
		
		D[1][0] = 1;
		for (int i = 2; i <= max; i++) {
			D[i][0] = D[i-1][0] + D[i-1][1];
			D[i][1] = D[i-1][0];
		}
		
		int ans = 1;
		
		for (int k : list) {
			if (k == 0)	continue;
			int sum = 0;
			sum = D[k][0] + D[k][1];
			ans *= sum;
		}
		
		System.out.println(ans);
		
		sc.close();
	}

}
