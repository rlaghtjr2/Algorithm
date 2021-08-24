import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo2473 {
	static int N,ansStart,ansEnd,ansMid;
	static long ans;
	static long[] liquid;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		liquid = new long[N];
		for(int i=0;i<N;i++) {
			liquid[i] = Integer.parseInt(input[i]);
		}
		ans = Long.MAX_VALUE;
		Arrays.sort(liquid);
		for(int i=0;i<N;i++) {
			twoPointer(i);
		}
		long[] ansArray = new long[3];
		ansArray[0] = liquid[ansStart];
		ansArray[1] = liquid[ansEnd];
		ansArray[2] = liquid[ansMid];
		Arrays.sort(ansArray);
		for(int i=0;i<3;i++) {
			System.out.print(ansArray[i]+ " ");
		}
	}
	
	public static void twoPointer(int mid) {
		int start = 0;
		int end = liquid.length-1;
		
		while(start<end && start<mid && mid<end) {
			long sum = liquid[mid] + liquid[start] + liquid[end];
			
			if(Math.abs(sum)<ans) {
				ans = Math.abs(sum);
				ansStart = start;
				ansEnd = end;
				ansMid = mid;
			}
		
			if(sum>0) end--;
			else start++;
			
			if(start==mid) start++;
			if(end==mid) end--;
		}
	}
}
