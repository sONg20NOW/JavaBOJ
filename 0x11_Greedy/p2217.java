import java.util.*;
import java.io.*;

public class Solution
{
	static int N;
	static int[] rope;

	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		rope = new int[N];
		for (int i = 0; i < N; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope);
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, (N-i) * rope[i]);
		}
		
		 System.out.println(ans);
		 br.close();
	}
}
