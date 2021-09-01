import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo1940 {
	static int N,M,ans;
	static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		nums = new int[N];
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(nums);
		twoPointer();
		System.out.println(ans);
	}
	private static void twoPointer() {
		int start = 0;
		int end = N-1;
		
		while(start<end) {
			int sum = nums[start]+nums[end];
			
			if(sum==M) {
				ans++;
				start++;
				end--;
			}else if(sum<M) {
				start++;
			}else {
				end--;
			}
		}
	}

}
