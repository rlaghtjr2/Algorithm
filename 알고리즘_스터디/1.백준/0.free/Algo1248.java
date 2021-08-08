import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1248 {
	static int N;
	static String[][] array;
	static int[] nums;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split("");
		
		array = new String[N][N];
		nums = new int[N];
		int cnt =0;
		for(int i=0;i<N;i++) {
			for(int j=i;j<N;j++) {
				array[i][j] = input[cnt];
				cnt++;
			}
		}
		make(0);
	}
	
	public static void make(int num) {
		if(num==N) {
			for(int i=0;i<N;i++) {
				System.out.print(nums[i]+" ");
			}
			System.exit(0);
		}
		
		for(int i=-10;i<=10;i++) {
			nums[num] = i;
			if(check(num)) make(num+1);
			
		}
	}
	
	public static boolean check(int num) {
		for(int i=0;i<=num;i++) {
			for(int j=i;j<=num;j++) {
				int n = sum(i,j);
				if(n>0) {
					if(!array[i][j].equals("+")) {
						return false;
					}
				}else if(n==0) {
					if(!array[i][j].equals("0")){
						return false;
					}
				}else {
					if(!array[i][j].equals("-")) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static int sum(int start, int end) {
		int num = 0;
		for(int i=start;i<=end;i++) {
			num += nums[i];
		}
		return num;
	}
}
