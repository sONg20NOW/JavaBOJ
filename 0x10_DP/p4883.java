package samsung01;

import java.util.Scanner;

public class p4883 {
	static int N;
	static int[][] Node;
	static int[][] D;
	static int test_case = 1;
	
	public static void PrintD() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.printf("%d ", D[i][j]);
			}
			System.out.printf("\n");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(true) {
			N = sc.nextInt();

			if (N == 0)	{
				break;
			}
			
			
			Node = new int[N][3];
			D = new int[N][3];
		
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					Node[i][j] = sc.nextInt();
				}
			}
			
			// 초기값 설정
			for (int j = 0; j < 3; j++) {
				D[0][j] = Node[0][1];
			}
			
			for (int i = 1; i < N; i++) {
				D[i][0] = Node[i][0] + Math.min(D[i-1][0], D[i-1][1]);
				D[i][1] = Node[i][1] + Math.min(Math.min(D[i-1][0], D[i-1][1]), Math.min(D[i-1][2], D[i][0]));
				D[i][2] = Node[i][2] + Math.min(Math.min(D[i-1][1], D[i-1][2]), D[i][1]);
			}
			
//			PrintD();
			
			System.out.printf("%d. %d\n", test_case++, D[N-1][1]);
		}
		
		sc.close();
	}

}
