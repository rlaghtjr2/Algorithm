import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo3273 {
	static int N,X,ans;
	static int[] array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		array = new int[N];
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(input[i]);
		}
		X = Integer.parseInt(br.readLine());
		Arrays.sort(array);
		twoPointer();
		System.out.println(ans);
	}
	
	
	public static void twoPointer() {
		int start = 0;
		int end = array.length-1;
		
		while(start<end) {
			int sum = array[start]+array[end];
			
			if(sum == X) {
				ans++;
			}
			if(sum<=X) {
				start++;
			}else {
				end--;
			}
		}
	}
}
