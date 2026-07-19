import java.util.*;
import java.io.*;

class Node {
	int x, y;
	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class p1520 {

	static int N, M;
	static int[][] board;
	static int[][] D;
	static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	
	static boolean OOB(int x, int y) {
		return (x < 0 || y < 0 || x >= N || y >= M);
	}
	
	// 구멍칸인지 여부를 확인하는 함수
	static boolean isHole(int x, int y) {
		if (x == N-1 && y == M-1) return false;
		for (int[] d : dir) {
			int dx = d[0] + x;
			int dy = d[1] + y;
			if (OOB(dx, dy))	continue;
			if (board[dx][dy] < board[x][y])	return false;
		}
		return true;
	}
	
	// (x, y) 주변에 얘보다 낮은 칸들의 D값의 총합을 반환하는 함수
	// 단, 업데이트 되지 않은 칸이 있다면 -1 반환
	static int isLowUpdate(int x, int y) {
		int sum = 0;
		for (int[] d : dir) {
			int dx = x + d[0];
			int dy = y + d[1];
			if (OOB(dx, dy))	continue;
			if (board[dx][dy] < board[x][y]) {
				if (D[dx][dy] < 0)	return -1;
				else sum += D[dx][dy];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		D = new int[N][M];
		for (int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				D[i][j] = -1;
			}
		}
		
		Queue<Node> Q = new ArrayDeque<>();
		
		// 구멍 칸들을 0으로 업데이트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isHole(i, j)) {
					D[i][j] = 0;
					Q.add(new Node(i, j));
				}
			}
		}
		
		D[N-1][M-1] = 1;
		Q.add(new Node(N-1, M-1));
		
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			for (int[] d : dir) {
				int dx = cur.x + d[0];
				int dy = cur.y + d[1];
				if (OOB(dx, dy))	continue;
				if (D[dx][dy] >= 0)	continue;
				int res = isLowUpdate(dx, dy);
				if (res < 0)	continue;
				D[dx][dy] = res;
				Q.add(new Node(dx, dy));
			}
		}
		
		System.out.println(D[0][0]);

		br.close();
	}

}
