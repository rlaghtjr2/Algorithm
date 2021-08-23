import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1024 {
	static int N,L;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		L = Integer.parseInt(input[1]);
		
		for(int i=L;i<=100;i++) {
			int num = N-(i*(i+1)/2);
			
			if(num%i==0) {
				int x = num/i +1;
				
				if(x>=0) {
					for(int j=0;j<i;j++) {
						System.out.print(x+j+" ");
					}
					System.out.println();
					System.exit(0);
				}
			}
		}
		System.out.println(-1);
	}
	
}
