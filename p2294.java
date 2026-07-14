package samsung01;

import java.util.*;

public class p2294 {

	static int n, k;
	static int[] coins;
	static int[] D;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		coins = new int[n];
		D = new int[k+1];
		
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		
		Arrays.sort(coins);
		
		
		for (int price : coins) {
			for (int i = price; i<=k; i++) {
				if (i == price)	D[i] = 1;
				else if (D[i-price] != 0)	D[i] = Math.min(D[i-price] + 1, D[i] != 0 ? D[i] : k+1);
			}
		}
		
		System.out.println(D[k] == 0 ? -1 : D[k]);
		
		sc.close();
	}

}
