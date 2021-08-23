import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo2470 {
	static int N,ans,ansStart,ansEnd;
	static int[] liquid;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		
		liquid = new int[N];
		input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++) {
			liquid[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(liquid);
		ans = Integer.MAX_VALUE;
		twoPointer();
		System.out.println(liquid[ansStart]+" "+liquid[ansEnd]);
	}
	private static void twoPointer() {
		int start = 0;
		int end = liquid.length-1;
		while(start<end) {
			int sum = liquid[start] + liquid[end];
			if(Math.abs(sum)<ans) {
				ans = Math.abs(sum);
				ansStart = start;
				ansEnd = end;
			}
			
			if(sum<0) start++;
			else end--;
			
		}
	}

}
