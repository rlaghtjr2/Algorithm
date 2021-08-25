import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo7453 {
	static int N;
	static long ans;
	static long[] A,B,C,D;
	static long[] AB,CD;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		A = new long[N];
		B = new long[N];
		C = new long[N];
		D = new long[N];
		AB = new long[N*N];
		CD = new long[N*N];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			A[i] = Long.parseLong(input[0]);
			B[i] = Long.parseLong(input[1]);
			C[i] = Long.parseLong(input[2]);
			D[i] = Long.parseLong(input[3]);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				AB[i*N+j] = A[i] + B[j];
				CD[i*N+j] = C[i] + D[j];
			}
		}
		
		Arrays.sort(AB);
		Arrays.sort(CD);
		twoPointer();
		System.out.println(ans);
	}
	
	public static void twoPointer() {
		int start = 0;
		int end = CD.length-1;
		
		while(start<AB.length && end>=0) {
			long sum = AB[start] + CD[end];
			if(sum==0) {
				int firstNum = 0;
				int secondNum = 0;
				long ABNum = AB[start];
				long CDNum = CD[end];
				while(true) {
					if(start>=AB.length) break;
					if(AB[start]!=ABNum) break;
					start++;
					firstNum++;
				}
				while(true) {
					if(end<0) break;
					if(CD[end]!=CDNum)break;
					end--;
					secondNum++;
				}
				ans+=((long)firstNum*(long)secondNum);
			}
			else if(sum<0) start++;
			else end--;
		}
	}

}
