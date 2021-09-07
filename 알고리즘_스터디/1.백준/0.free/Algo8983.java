import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo8983 {
	static int M,N,L,ans;
	static int[] guns;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		M = Integer.parseInt(input[0]);
		N = Integer.parseInt(input[1]);
		L = Integer.parseInt(input[2]);
		
		guns = new int[M];
		
		input = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			guns[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(guns);
		
		for(int i=0;i<N;i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			if(y+Math.abs(binarySearch(x)-x)<=L) ans++;
		}
		
		System.out.println(ans);
	}
	
	public static int binarySearch(int animalX) {
		int start = 0;
		int end = M-1;
		int max = Integer.MAX_VALUE;
		while(start<=end) {
			int mid = (start+end)/2;
			
			if(guns[mid]==animalX) return guns[mid];
			else if(guns[mid]>animalX) end = mid-1;
			else start = mid+1;
			
			if(Math.abs(animalX-max)>Math.abs(animalX-guns[mid])) {
				max = guns[mid];
			}
			
		}
		return max;
	}
}
