import java.util.*;

public class p2293 {
	static int n, k;
	static int[] D;
	static int[] coins;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		
		D = new int[k+1];
		coins = new int[n];
		
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		
		Arrays.sort(coins);
		D[0] = 1;
		
		for (int price : coins) {
			for (int i = price; i <= k; i++) {
				D[i] += D[i-price];
			}
		}
		
		System.out.println(D[k]);
		
		sc.close();
	}

}
