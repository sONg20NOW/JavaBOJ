
import java.util.*;
import java.io.*;

public class p1439 {

	static char[] S;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine().toCharArray();
		
		int change = 0;
		char cur = S[0];
		for (char c : S) {
			if (cur != c) {
				change++;
				cur = c;
			}
		}
		
		System.out.println((change + 1) / 2);
		
		br.close();
	}

}
